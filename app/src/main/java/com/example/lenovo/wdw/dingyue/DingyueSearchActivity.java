package com.example.lenovo.wdw.dingyue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.wdw.R;

public class DingyueSearchActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView dingyue_search_back;
    private EditText dingyue_search_text;
    private TextView dingyue_search_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingyue_search);
        initView();
    }

    private void initView() {
        dingyue_search_back = (ImageView) findViewById(R.id.dingyue_search_back);
        dingyue_search_back.setOnClickListener(this);
        dingyue_search_text = (EditText) findViewById(R.id.dingyue_search_text);
        dingyue_search_submit = (TextView) findViewById(R.id.dingyue_search_submit);
        dingyue_search_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回键
            case R.id.dingyue_search_back:
                finish();
                break;
            //搜索提交按钮
            case R.id.dingyue_search_submit:
                String text = dingyue_search_text.getText().toString().trim();
                if (TextUtils.isEmpty(text)) {
                    Toast.makeText(this, "没有搜索内容...", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this, "正在搜索-"+text, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "搜索失败!", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
