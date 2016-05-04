package com.example.lenovo.wdw.fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.RedianInListView;
import com.example.lenovo.wdw.models.RedianListView;
import com.example.lenovo.wdw.models.RedianListViewImage;
import com.example.lenovo.wdw.redian.RedianDesignOneActivity;
import com.example.lenovo.wdw.redian.RedianDesignTwoActivity;
import com.example.lenovo.wdw.redian.RedianLikeActivity;
import com.example.lenovo.wdw.adapters.RedianListViewAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 热点界面
 * A simple {@link Fragment} subclass.
 */
public class RedianFragment extends Fragment implements View.OnClickListener, PullToRefreshBase.OnRefreshListener2, AdapterView.OnItemClickListener {
    //定义一个TAG,方便MainActivity调用
    public static final String TAG = RedianFragment.class.getSimpleName();
    private static int page = 10;
    private static final String URL = "http://c.m.163.com/nc/article/headline/T1348647853363/0-" + page + ".html";
    private ImageView Biaoqian;
    private ImageView mine;
    private PullToRefreshListView refresh;
    private RedianListViewAdapter adapter;
    private ListView listView;
    private View view;
    private ArrayList<RedianListView> data;


    public RedianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //通知栏颜色与背景同步
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        view = inflater.inflate(R.layout.fragment_redian, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        RequestParams params = new RequestParams(URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONArray jsonArray = new JSONObject(result).getJSONArray("T1348647853363");
                    Log.e(TAG, "jsonArray--" + jsonArray.toString());
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<RedianListView>>() {
                    }.getType();
                    data = gson.fromJson(jsonArray.toString(), type);
                    Log.e(TAG, "data" + data.get(0).getLtitle() + "---" + data.get(0).getImgsrc());
                    adapter.updataData(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled");
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished" + data.get(0).getLtitle());
            }
        });
    }


    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.redian_add_listview, null);
        ImageView image = (ImageView) inflate.findViewById(R.id.reDian_add_listView_iv);
        TextView title = (TextView) inflate.findViewById(R.id.reDian_add_listView_tv);
        Biaoqian = ((ImageView) view.findViewById(R.id.reDian_biaoqian));
        mine = ((ImageView) view.findViewById(R.id.reDian_wode));
        refresh = ((PullToRefreshListView) view.findViewById(R.id.refresh));
        //将pullToRefreshListView转化为ListView
        listView = refresh.getRefreshableView();
        listView.setDivider(getContext().getResources().getDrawable(R.color.colorGreylight));
        listView.setDividerHeight(20);
        listView.setOnItemClickListener(this);
        //ListView的适配器
        adapter = new RedianListViewAdapter(getData(), getActivity(), R.layout.redian_listview_item_two);
        //为listView添加头部
//        listView.addHeaderView(inflate);
        //添加适配器
        listView.setAdapter(adapter);
        refresh.setOnRefreshListener(this);
        //设置refresh刷新为双向刷新
        refresh.setMode(PullToRefreshBase.Mode.BOTH);
        //设置监听事件
        Biaoqian.setOnClickListener(this);
        mine.setOnClickListener(this);
    }

    private ArrayList<RedianListView> getData() {
        ArrayList<RedianListView> data = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            RedianListView model = new RedianListView();
//            model.setLtitle("这是假数据--" + i);
//            data.add(model);
//        }
        return data;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reDian_biaoqian:
                Intent intent = new Intent(getActivity(), RedianLikeActivity.class);
                startActivity(intent);
                break;
            case R.id.reDian_wode:
                Toast.makeText(getContext(), "功能正在开发中---", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page += 10;
        initData();
        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh.onRefreshComplete();
            }
        }, 1000);

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page += 10;
        initData();
        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh.onRefreshComplete();
            }
        }, 1000);
    }

    public void addData() {
        RequestParams params = new RequestParams(URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONArray jsonArray = new JSONObject(result).getJSONArray("T1348647853363");
                    Log.e(TAG, "jsonArray--" + jsonArray.toString());
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<RedianListView>>() {
                    }.getType();
                    data = gson.fromJson(jsonArray.toString(), type);
                    Log.e(TAG, "data" + data.get(0).getLtitle() + "---" + data.get(0).getImgsrc());
                    adapter.addData(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled");
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished" + data.get(0).getLtitle());
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        int type = adapter.getItem(position - 1).getType();
//        switch (type) {
//            case 0:
        Intent intent = new Intent(getActivity(), RedianDesignOneActivity.class);
        intent.putExtra("postion", position);
        intent.putParcelableArrayListExtra("data", data);
        startActivity(intent);
//                break;
//            case 1:
//        Intent two = new Intent(getActivity(), RedianDesignTwoActivity.class);
//        startActivity(two);
//                break;
//        }
    }
}
