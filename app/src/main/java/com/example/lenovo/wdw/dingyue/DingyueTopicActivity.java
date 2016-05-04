package com.example.lenovo.wdw.dingyue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lenovo.wdw.MyApp;
import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.adapters.DingyueTopicAdapter;
import com.example.lenovo.wdw.models.DingyueContentModel;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.nio.channels.Pipe;
import java.util.List;

public class DingyueTopicActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG=DingyueTopicActivity.class.getSimpleName();
    private ImageView dingyue_topic_topImg;
    private ListView dingyue_topic_listView;
    private String topicUrl;
    private DingyueTopicAdapter adapter;
    private List<DingyueContentModel.DataBean.ArticlesBean> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingyue_topic);
        initView();
        initData();
    }

    private void initData() {
        RequestParams TopicParams=new RequestParams(topicUrl);
        x.http().get(TopicParams, new Callback.CommonCallback<DingyueContentModel>() {
            @Override
            public void onSuccess(DingyueContentModel result) {
                DingyueContentModel.DataBean dataBean = result.getData();
                Log.e(TAG, "Topic-onSuccess" + dataBean.getBlock_info().getTitle());
                //设置Topic头部图片
                x.image().bind(dingyue_topic_topImg, dataBean.getBlock_info().getDiy().getBgimage_url(), MyApp.option);
                articles = dataBean.getArticles();
                adapter.upDateRes(articles);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "Topic-onError" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "Topic-onCancelled" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "Topic-onFinished" );
            }
        });
    }

    private void initView() {
        //获取订阅主页面传进来的Json地址
        topicUrl = getIntent().getStringExtra("topicUrl");
//        实例化view
        dingyue_topic_topImg = (ImageView) findViewById(R.id.dingyue_topic_topImg);
        dingyue_topic_listView = (ListView) findViewById(R.id.dingyue_topic_listView);
        //实例化适配器
        adapter = new DingyueTopicAdapter(this,null, R.layout.dingyue_topic_item);
        dingyue_topic_listView.setAdapter(adapter);
        dingyue_topic_listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this,""+ position,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DingyueDetailsActivity.class);
        intent.putExtra("title",articles.get(position).getTitle());
        intent.putExtra("web", articles.get(position).getWeburl());
        startActivity(intent);
    }
}
