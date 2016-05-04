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

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class FilmActivity extends Activity {


    private static final String TAG=FilmActivity.class.getSimpleName();

    private String URL;
    private ListView listView;
    private MyFenLeiAdapter adapter;
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

        listView = ((ListView) findViewById(R.id.listView_fen_lei));

    }

    private void initData() {
        RequestParams params=new RequestParams(URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG,"没有结果？？？？？？"+result);
                Gson gson=new Gson();
                WangData wangData = gson.fromJson(result, WangData.class);
                List<WWeekendS> weekends = wangData.getData().getWeekends();
                Log.e(TAG,"难道没有长度？？？？？"+weekends.size());
                adapter=new MyFenLeiAdapter(weekends,FilmActivity.this);
                listView.setAdapter(adapter);


            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG,"12321321312313123-----");
            }
            @Override
            public void onCancelled(CancelledException cex) {

            }
            @Override
            public void onFinished() {

            }
        });

    }


}
