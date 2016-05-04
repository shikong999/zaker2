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
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.SecondActivityFenlei;
import com.example.lenovo.wdw.adapters.MyListViewAdapter;
import com.example.lenovo.wdw.adapters.MyPagerAdapter;
import com.example.lenovo.wdw.models.Data;
import com.example.lenovo.wdw.models.WColumns;
import com.example.lenovo.wdw.models.WItems;
import com.example.lenovo.wdw.models.WPromote;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WanleFragment extends Fragment implements View.OnClickListener {
    private View view;
    public static final String TAG = WanleFragment.class.getSimpleName();
    private static final String URL = "http://wl.myzaker.com/?_appid=AndroidPhone&_v=6.5.1&_version=6.53&c=columns";

    private TextView cityName;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private ListView listView;

    private ImageView imageView;
    private ImageView imageViewPager;

    private MyListViewAdapter myListViewAdapter;
    private MyPagerAdapter myPagerAdapter;

    private List<String> listUrl = new ArrayList<>();
    private List<String> listUrl1 = new ArrayList<>();
    private List<ImageView> imageViews = new ArrayList<>();
    private List<Object> listContent = new ArrayList<>();

    private Handler handler;


    public WanleFragment() {
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
        view = inflater.inflate(R.layout.fragment_wanle, container, false);
        cityName = ((TextView) view.findViewById(R.id.jie_textView_city));
        cityName.setOnClickListener(this);
        viewPager = new ViewPager(getContext());
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        AbsListView.LayoutParams params1 = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
        viewPager.setLayoutParams(params1);
        linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(params);
        listView = ((ListView) view.findViewById(R.id.jie_listView));
        initData();
        return view;
    }

    private void initData() {
        final RequestParams params = new RequestParams(URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "_+_+_+_+_+_+_心事浩茫连广宇，于无声处听惊雷" + result);
                Gson gson = new Gson();
                Data data = gson.fromJson(result, Data.class);
                Log.e(TAG, "难道没有走？");
                List<WColumns> columns = data.getData().getColumns();
                for (int i = 0; i < columns.size(); i++) {
                    String m_url = columns.get(i).getBanner().getM_url();//
                    listContent.add(m_url);
                    List<WItems> items = columns.get(i).getItems();
                    for (int j = 0; j < items.size(); j++) {
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        String title = items.get(j).getTitle();//图片标题
                        String content = items.get(j).getContent();//标题内容
                        String url = items.get(j).getPic().getUrl();//图片地址
                        hashMap.put("title", title);
                        hashMap.put("content", content);
                        hashMap.put("url", url);
                        listContent.add(hashMap);
                    }
                }
                myListViewAdapter = new MyListViewAdapter(listContent,getContext().getApplicationContext());
                listView.setAdapter(myListViewAdapter);
                listView.addHeaderView(viewPager);
                listView.addHeaderView(linearLayout);
                Log.e(TAG, "WPromote" + columns.size());
                for (int i = 0; i < data.getData().getDisplay().size(); i++) {
                    String url = data.getData().getDisplay().get(i).getPic().getM_url();
                    Log.e(TAG, url);
                    imageView = new ImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setLayoutParams(layoutParams);
                    ImageLoader.getInstance().displayImage(url, imageView);
                    linearLayout.addView(imageView);
                }
                List<WPromote> promotes = data.getData().getPromote();
                Log.e(TAG, "WPromote" + promotes.size());
                for (int j = 0; j < promotes.size(); j++) {
                    String promotion_img = promotes.get(j).getPromotion_img();
                    listUrl1.add(promotion_img);
                    Log.e(TAG, promotion_img);
                    imageViewPager = new ImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    imageViewPager.setScaleType(ImageView.ScaleType.CENTER);
                    imageViewPager.setLayoutParams(layoutParams);
                    ImageLoader.getInstance().displayImage(promotion_img, imageViewPager);
                    imageViews.add(imageViewPager);
                }
                myPagerAdapter = new MyPagerAdapter(imageViews, getContext());
                viewPager.setAdapter(myPagerAdapter);
                autoLunbo(viewPager, imageViews);
                Log.e(TAG, "难道没有解析出来？");
                Log.e(TAG, "难道没有解析出来？" + columns.size());
                Log.e(TAG, "解析出来了");
                Log.e(TAG, "检查数组长度" + promotes.size() + "检查数组长度" + imageViews.size());

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "最讨厌看见你");
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }

    private void autoLunbo(final ViewPager viewPager, final List<ImageView> imageViews) {

        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {

                    try {
                        for (int i = 0; i < imageViews.size(); i++) {
                            Message message = new Message();
                            message.what = i;
                            handler.sendMessage(message);
                            Thread.sleep(3000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                viewPager.setCurrentItem(msg.what);
                return false;
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jie_textView_city:
                Intent intent = new Intent(getContext(), SecondActivityFenlei.class);
                startActivity(intent);
                break;
        }
    }

}


