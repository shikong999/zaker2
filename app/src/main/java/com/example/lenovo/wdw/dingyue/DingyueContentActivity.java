package com.example.lenovo.wdw.dingyue;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.adapters.MyViewPagerAdapter;
import com.example.lenovo.wdw.models.DingyueContentModel;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class DingyueContentActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private static final String TAG = DingyueContentActivity.class.getSimpleName();
    //json地址
    private String jsonUrl;
    //条目
    private ViewPager myViewPager;
    //ViewPager适配器
    private MyViewPagerAdapter adapter;
    //ViewPager数据源
    private List<Fragment> fragmentArrayList;
    //页码指示器
    private TextView dingyue_content_index;
    //下一页信息
    private DingyueContentModel.DataBean.infoBean infoBean;
    //页码缓存
    private int tempPosition = 1;
//    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingyue_content);
        initView();
        initData();
    }

    private void initData() {
        RequestParams contentParams = new RequestParams(jsonUrl);
        x.http().get(contentParams, new Callback.CommonCallback<DingyueContentModel>() {
            @Override
            public void onSuccess(DingyueContentModel result) {
                DingyueContentModel.DataBean data = result.getData();
                infoBean = data.getInfo();
                Log.e(TAG, "订阅内容-onSuccess" + data.getArticles().get(0).getTitle());
                //获取top图片地址
                DingyueContentModel.DataBean.IpadconfigBean.PagesBean.DiyBean diy = data.getIpadconfig().getPages().get(0).getDiy();
                String bgimage_url = "http://zkres.myzaker.com/data/topic/iphone/zaker_early_banner.png?1";
                if (diy != null) {
                    bgimage_url = diy.getBgimage_url();
                }
                //获取条目数据源
                List<DingyueContentModel.DataBean.ArticlesBean> articles = data.getArticles();
                Log.e(TAG, "onSuccess-articles-" + data.getArticles().size());
                for (int i = 0; i < articles.size(); i += 6) {
                    //数据源拆分,每6个分一份
                    List<DingyueContentModel.DataBean.ArticlesBean> subList = articles.subList(i, i + 6);
                    Log.e(TAG, "articles-" + i + ":" + subList.size());
                    //初始化fragment
                    DingyueContentItemFragment fragment = new DingyueContentItemFragment();
                    //用Bundle传递新闻数据
                    Bundle bundle = new Bundle();
                    //传递top图片地址
                    bundle.putString("topImg", bgimage_url);
                    //向Item中传递数据
                    for (int j = 0; j < subList.size(); j++) {
                        //获取单个新闻的数据
                        DingyueContentModel.DataBean.ArticlesBean bean = subList.get(j);
//                    bundle.putParcelableArrayList("data",subList);
                        bundle.putParcelable("news" + j, bean);
                    }
                    //传递数据
                    fragment.setArguments(bundle);
                    fragmentArrayList.add(fragment);
                    adapter.updateRes(fragmentArrayList);
                }
                //重置总页码
                dingyue_content_index.setText(tempPosition + "/" + adapter.getCount());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "订阅内容-onError" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "订阅内容-onCancelled" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "订阅内容-onFinished");
            }
        });
//        pd.dismiss();
//        Log.e(TAG, "进度条" + pd.isShowing());
    }

    private void initView() {
        //获取订阅主页面传进来的Json地址
        jsonUrl = getIntent().getStringExtra("contentUrl");
        fragmentArrayList = new ArrayList<>();
        //实例化ViewPager
        myViewPager = (ViewPager) findViewById(R.id.dingyue_content_viewPager);
        //实例化ViewPager适配器
        adapter = new MyViewPagerAdapter(getSupportFragmentManager(), null);
        //绑定适配器
        myViewPager.setAdapter(adapter);
        //ViewPager添加监听
        myViewPager.setOnPageChangeListener(this);
        //实例化页码指示器
        dingyue_content_index = (TextView) findViewById(R.id.dingyue_content_index);

//        pd = new ProgressDialog(this);// 创建ProgressDialog对象
//             pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条风格，风格为圆形，旋转的
//             pd.setTitle("提示");// 设置ProgressDialog 标题
//             pd.setMessage("这是一个圆形进度条对话框");// 设置ProgressDialog提示信息
//             pd.setIcon(R.mipmap.icon);// 设置ProgressDialog标题图标
//             // 设置ProgressDialog 的进度条是否不明确 false 就是不设置为不明确
//             pd.setIndeterminate(false);
//             pd.setCancelable(true); // 设置ProgressDialog 是否可以按退回键取消
////             pd.setButton("确定", new Bt1DialogListener()); // 设置ProgressDialog 的一个Button
//             pd.show(); // 让ProgressDialog显示
//        Log.e(TAG,"进度条"+pd.isShowing());
    }

    //***********************ViewPager监听*****************************
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 当viewpager滑到最后,加载下一页
     *
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        tempPosition = position + 1;
        if (adapter.getCount() - 1 == position && infoBean != null) {
            jsonUrl = infoBean.getNext_url();
            initData();
        }
        dingyue_content_index.setText(position + 1 + "/" + adapter.getCount());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
