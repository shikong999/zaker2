package com.example.lenovo.wdw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.lenovo.wdw.adapters.MyFenLeiAdapter;
import com.example.lenovo.wdw.models.WWeekendS;
import com.example.lenovo.wdw.models.WangData;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class FenLeiActivity extends Activity implements PullToRefreshBase.OnRefreshListener2{


    private static final String TAG=FenLeiActivity.class.getSimpleName();

    private String URL;
    private PullToRefreshListView listView;
    private ListView list;
    private MyFenLeiAdapter adapter;
    private List<WWeekendS> weekends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yan_yi);
        Intent intent = getIntent();
        URL = intent.getStringExtra("url");
        Log.e(TAG,"====看看有没有传值====="+URL);
        initView();
        initData();
    }

    private void initView() {

        listView = ((PullToRefreshListView) findViewById(R.id.listView_fen_lei));
        list=listView.getRefreshableView();
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(this);


    }

    private void initData() {

        RequestParams params=new RequestParams(URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "没有结果？？？？？？" + result);
                Gson gson = new Gson();
                WangData wangData = gson.fromJson(result, WangData.class);
                weekends = wangData.getData().getWeekends();
                Log.e(TAG, "难道没有长度？？？？？" + weekends.size());
                adapter = new MyFenLeiAdapter(weekends, FenLeiActivity.this);
                list.setAdapter(adapter);

                //data(weekends);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "12321321312313123-----");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    private void data(List<WWeekendS> weekends) {
       adapter.UpdateRea(weekends);
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        initData();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        initData();
    }
}
