package com.example.lenovo.wdw.fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.adapters.DingyueMenuAdapter;
import com.example.lenovo.wdw.adapters.MyViewPagerAdapter;
import com.example.lenovo.wdw.dingyue.DingyueContentActivity;
import com.example.lenovo.wdw.dingyue.DingyueSearchActivity;
import com.example.lenovo.wdw.dingyue.DingyueTopicActivity;
import com.example.lenovo.wdw.dingyue.ViewPagerItemFragment;
import com.example.lenovo.wdw.models.DingyueMenuModel;
import com.example.lenovo.wdw.models.DingyueViewPageModel;
import com.example.lenovo.wdw.view.MyGridView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DingyueFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener, Handler.Callback, AdapterView.OnItemClickListener {

    public static final String TAG = DingyueFragment.class.getSimpleName();
    private ImageView dingyue_search;//搜索按钮
    private ImageView dingyue_user;//用户按钮
    //轮播图url
    private String viewPagerUrl = "http://iphone.myzaker.com/zaker/follow_promote.php?_appid=AndroidPhone&_bsize=720_1280&_dev=515&_lat=4.9E-324&_lng=4.9E-324&_mac=32%3A3A%3A64%3AAF%3A67%3A93&_mcode=DDF8B313&_net=wifi&_nudid=754b360e84ac19e7&_os=4.4.2_Nexus5&_os_name=Nexus5&_udid=352284040670808&_v=6.5.1&_version=6.53&m=1460315041";
    //菜单Url
    private String gridUrl = "http://iphone.myzaker.com/zaker/rootblock.php?_appid=AndroidPhone&_bsize=720_1280&_dev=515&_lat=4.9E-324&_lng=4.9E-324&_mac=32%3A3A%3A64%3AAF%3A67%3A93&_mcode=DDF8B313&_net=wifi&_nudid=754b360e84ac19e7&_os=4.4.2_Nexus5&_os_name=Nexus5&_udid=352284040670808&_v=6.5.1&_version=6.53";
    private ViewPager dingyue_viewpager;//轮播图
    private MyViewPagerAdapter adapter;//轮播图适配器
    private List<Fragment> data;//MyViewPagerAdapter的数据源
    private LinearLayout indicator;//导航点
    private int cachePosition;//导航点缓存坐标
    private Handler myHandler;
    private int index = 0;
    private MyGridView dingyue_grid_menu;//gridView即订阅的菜单
    private DingyueMenuAdapter menuAdapter;//订阅的菜单的适配器
    private List<DingyueMenuModel.DataBean.BlocksDataBean> blocksData;//订阅的菜单的数据源


    public DingyueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //通知栏颜色与背景同步
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        View view = inflater.inflate(R.layout.fragment_dingyue, container, false);
        //初始化视图
        initView(view);
        //初始化数据
        initData();
        return view;
    }


    private void initData() {
        //获取gridview数据
        RequestParams gridParams = new RequestParams(gridUrl);
        x.http().get(gridParams, new Callback.CommonCallback<DingyueMenuModel>() {
            @Override
            public void onSuccess(DingyueMenuModel result) {
//                Log.e(TAG, "菜单_onSuccess_" + result.getData().getBlocksData().get(0));
                blocksData = result.getData().getBlocksData();
                blocksData.remove(0);
                menuAdapter.updateRes(blocksData);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
//                Log.e(TAG, "菜单_onError_" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
//                Log.e(TAG, "菜单_onCancelled_" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "菜单_onFinished");
            }
        });

        //获取viewpager数据
        RequestParams viewpagerParams = new RequestParams(viewPagerUrl);
        x.http().get(viewpagerParams, new Callback.CommonCallback<DingyueViewPageModel>() {
            @Override
            public void onSuccess(DingyueViewPageModel result) {
//                Log.e(TAG, "轮播图onSuccess_" + result);
                //解析轮播图数据
                List<DingyueViewPageModel.DataBean.ListBean> list = result.getData().getList();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    // 用代码实例化一个ImageView

                    // 动态生成导航点
                    ImageView imageView = new ImageView(getContext());
                    // 第一个位置设置为选中的icon
                    if (i == 0) {
                        imageView.setImageResource(R.mipmap.img_dot_white);
                    } else {
                        imageView.setImageResource(R.mipmap.img_dot_gray);
                    }
                    //导航点设置监听
                    imageView.setOnClickListener(DingyueFragment.this);
                    // 将ImageView添加到导航的LinearLayout中
                    indicator.addView(imageView);
                    //*********************************************
                    // 动态添加ViewPager
                    DingyueViewPageModel.DataBean.ListBean listBean = list.get(i);
                    ViewPagerItemFragment pagerItemFragment = new ViewPagerItemFragment();
                    Bundle bundle = new Bundle();
                    //传递对象,要实现Parcelable
                    bundle.putParcelable("key", listBean);
                    pagerItemFragment.setArguments(bundle);
                    data.add(pagerItemFragment);
                    adapter.updateRes(data);
                }

//                //
//                for (int i = 0; i < 4; i++) {
//                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
//                Log.e(TAG, "轮播图-onError" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
//                Log.e(TAG, "轮播图-onCancelled" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "轮播图-onFinished");
            }
        });
        //轮播图自动滚动
        myHandler = new Handler(this);
        Message msg = Message.obtain();
        msg.what = 1;
        //延迟7秒
        myHandler.sendMessageDelayed(msg, 7000);
        dingyue_viewpager.setCurrentItem(index++);
    }

    private void initView(View view) {
        //搜索按钮
        dingyue_search = (ImageView) view.findViewById(R.id.dingyue_search);
        //搜索按钮监听
        dingyue_search.setOnClickListener(this);
        //用户按钮
        dingyue_user = (ImageView) view.findViewById(R.id.dingyue_user);
        //用户按钮监听
        dingyue_user.setOnClickListener(this);
//        实例化轮播图View
        dingyue_viewpager = (ViewPager) view.findViewById(R.id.dingyue_viewpager);
        //实例化数据源
        data = new ArrayList<>();
        //实例化轮播图适配器
        adapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager(), null);
        //设置适配器
        dingyue_viewpager.setAdapter(adapter);
        //为viewpager设置监听
        dingyue_viewpager.setOnPageChangeListener(this);
        indicator = (LinearLayout) view.findViewById(R.id.indicator);

//****************************************************
        //订阅菜单
        dingyue_grid_menu = (MyGridView) view.findViewById(R.id.dingyue_grid_menu);
        //初始化的假数据
        List<DingyueMenuModel.DataBean.BlocksDataBean> menuData = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            DingyueMenuModel.DataBean.BlocksDataBean blackModel = new DingyueMenuModel.DataBean.BlocksDataBean();
            blackModel.setTitle("标题" + i);
            menuData.add(blackModel);
        }
        //实例化GridAdapter
        menuAdapter = new DingyueMenuAdapter(getContext(), menuData);
        dingyue_grid_menu.setFocusable(false);
        //绑定
        dingyue_grid_menu.setAdapter(menuAdapter);
        //gridView监听
        dingyue_grid_menu.setOnItemClickListener(this);
    }

    //*******************ViewPager监听*********************

    //滚动中
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    //page改变
    @Override
    public void onPageSelected(int position) {

        /**
         * ① 将缓存下来的位置 导航点还原状态
         * ② 将选中位置对应的导航点设置为选中状态
         * ③ 缓存选中的位置
         */
        //自动滚动位置定位为当前页
        index = position;
        ImageView imageView = (ImageView) indicator.getChildAt(cachePosition);
        imageView.setImageResource(R.mipmap.img_dot_gray);
        //导航点
        ImageView imageViewSelect = (ImageView) indicator.getChildAt(position);
        imageViewSelect.setImageResource(R.mipmap.img_dot_white);
        cachePosition = position;
    }


    //滚动状态改变
    @Override
    public void onPageScrollStateChanged(int state) {
    }

    //***************单击监听*************
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dingyue_search:

                Intent  intent = new Intent(getContext(), DingyueSearchActivity.class);
//            intent.putExtra("topicUrl", "http://iphone.myzaker.com/zaker/topic.php?app_id=660&topic_id=570ea541a07aecb57f000006");
                startActivity(intent);
                break;
            case R.id.dingyue_user:
                Toast.makeText(getContext(), "没有此用户", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //*************Handle回调***************
    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            //viewpager自动滚动
            case 1:
                Message message = Message.obtain();
                message.what = 1;
                myHandler.sendMessageDelayed(message, 7000);
                dingyue_viewpager.setCurrentItem(index++);
                if (index >= 4) {
                    index = 0;
                }
                break;
        }
        return true;
    }


    //******************gridView监听**********************
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //如果点击最后一个条目
        if (menuAdapter.getCount() - 1 == position) {
//            Toast.makeText(getContext(), "添加功能开发中", Toast.LENGTH_SHORT).show();
           Intent  intent = new Intent(getContext(), DingyueSearchActivity.class);
//            intent.putExtra("topicUrl", "http://iphone.myzaker.com/zaker/topic.php?app_id=660&topic_id=570ea541a07aecb57f000006");
            startActivity(intent);
        } else {
            //否则,进入相应频道
            DingyueMenuModel.DataBean.BlocksDataBean blocksDataBean = blocksData.get(position);

            Toast.makeText(getContext(), blocksDataBean.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), DingyueContentActivity.class);
            if (blocksDataBean.getTitle().equals("今日看点")) {
                intent.putExtra("content", "http://iphone.myzaker.com/zaker/daily_hot.php?app_id_4=310000");
            } else {
                intent.putExtra("contentUrl", blocksDataBean.getApi_url());
            }
            startActivity(intent);
        }
    }
}
