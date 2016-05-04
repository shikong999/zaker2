package com.example.lenovo.wdw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.wdw.adapters.MyGridViewAdapter;
import com.example.lenovo.wdw.models.WData;
import com.example.lenovo.wdw.models.WList;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class SecondActivityFenlei extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final String TAG=SecondActivityFenlei.class.getSimpleName();

    private static final String URL =
            "http://wl.myzaker.com/?_appid=AndroidPhone&_v=6.5.1&_version=6.53&c=category_list";
    private GridView gridView;

    private MyGridViewAdapter adapter;
    private TextView textView;

    private List<String> apiUrlData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity_fenlei);
        initView();
        initData();
    }

    private void initData() {

        RequestParams params=new RequestParams(URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "---result" + result);
                Gson gson = new Gson();
                WData data = gson.fromJson(result, WData.class);
                Log.e(TAG, "-------" + data.getData().getList().size());
                List<WList> list = data.getData().getList();
                for (int i = 0; i < list.size(); i++) {
                    apiUrlData.add(list.get(i).getApi_url());
                    Log.e(TAG, list.get(i).getApi_url());
                }
                adapter.updateRes(list);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "--onError");
            }
            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    private void initView() {
        gridView = ((GridView) findViewById(R.id.gridView_feilei));
        textView = ((TextView) findViewById(R.id.fenlei));
        textView.setOnClickListener(this);
        adapter=new MyGridViewAdapter(getData(),this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    private List<WList> getData() {
        List<WList> data = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            WList list = new WList();
            list.setCategory("加载内容"+i);
            data.add(list);
        }
        return data;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fenlei:
            Intent intent=new Intent(SecondActivityFenlei.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent intent0=new Intent();
                intent0.putExtra("精选", apiUrlData.get(0));
                intent0.setClass(SecondActivityFenlei.this,MainActivity.class);
                startActivity(intent0);
                break;
            case 1:
                Intent intent1=new Intent();
                intent1.putExtra("url", apiUrlData.get(1));
                intent1.setClass(SecondActivityFenlei.this,FenLeiActivity.class);
                startActivity(intent1);

                break;
            case 2:
                Intent intent2=new Intent();
                intent2.putExtra("url", apiUrlData.get(2));
                intent2.setClass(SecondActivityFenlei.this, FenLeiActivity.class);
                startActivity(intent2);

                break;
            case 3:

                Toast.makeText(this,"想想，我是谁？",Toast.LENGTH_SHORT).show();
//                Intent intent3=new Intent();
//                intent3.putExtra("url", apiUrlData.get(3));
//                intent3.setClass(SecondActivityFenlei.this, FenLeiActivity.class);
//                startActivity(intent3);

                break;
            case 4:
                Intent intent4=new Intent();
                intent4.putExtra("url", apiUrlData.get(4));
                intent4.setClass(SecondActivityFenlei.this, FenLeiActivity.class);
                startActivity(intent4);

                break;
            case 5:
                Intent intent5=new Intent();
                intent5.putExtra("url", apiUrlData.get(5));
                intent5.setClass(SecondActivityFenlei.this, FenLeiActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
