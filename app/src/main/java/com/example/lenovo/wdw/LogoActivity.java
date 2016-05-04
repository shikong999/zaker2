package com.example.lenovo.wdw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        //设置页面全屏(包括通知栏)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }
    private void init() {
        //延迟3秒,返回主页面
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                intent.putExtra("logo", true);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
