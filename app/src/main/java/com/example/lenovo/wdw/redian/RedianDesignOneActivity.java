package com.example.lenovo.wdw.redian;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.RedianListView;

import java.util.ArrayList;

public class RedianDesignOneActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redian_design_one);
        Intent intent=getIntent();
        int position = intent.getIntExtra("position", 0);
      ArrayList<RedianListView> data= intent.getParcelableArrayListExtra("data");
        url = data.get(position).getUrl();
        initView();
    }

    private void initView() {
        progressBar = ((ProgressBar) findViewById(R.id.progress));
        webView = (WebView) findViewById(R.id.reDian_xianQing_webView);
        webView.loadUrl(url);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress>0&&newProgress<100){
                    progressBar.setProgress(newProgress);
                    progressBar.setProgress(View.VISIBLE);
                }else {
                    progressBar.setProgress(View.GONE);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode== KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()){
                //调用WebView的回退，消费事件
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
