package com.example.lenovo.wdw.dingyue;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.utils.QQUtil;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import java.io.File;
import java.util.ArrayList;

public class DingyueDetailsActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private WebView dingyue_web;
    private ProgressBar dingyue_web_Bar;//网页进度条
    private static final String APP_CACHE_DIRNAME = "/webcache"; // web缓存目录
    private ImageView share;
    private String webUrl;
    private String title;
    private String APP_ID = "222222";
    private static Tencent mTencent;
    private TextView shareto_topic;
    private TextView share_weixin;
    private TextView share_friends;
    private TextView share_sina;
    private TextView share_qq;
    private TextView share_qqzone;
    private TextView share_qq_collect;
    private TextView share_email;
    private TextView share_evernote;
    private TextView share_pock;
    private TextView share_kindle;
    private TextView share_more;
    private TextView share_report;
    private TextView share_favor;
    private View shareView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingyue_details);
        mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());
        initView();
    }

    private void initView() {
        Intent info = getIntent();
        title = info.getStringExtra("title");
        //获取webUrl
        webUrl = info.getStringExtra("web");
        //实例化View
        dingyue_web_Bar = (ProgressBar) findViewById(R.id.dingyue_web_Bar);
        dingyue_web = (WebView) findViewById(R.id.dingyue_web);
        //获取webView设置
        WebSettings settings = dingyue_web.getSettings();
        //运行JavaScript
        settings.setJavaScriptEnabled(true);
        dingyue_web.setWebViewClient(new WebViewClient());
        //加载进度条
        dingyue_web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                dingyue_web_Bar.setVisibility(View.VISIBLE);
                dingyue_web_Bar.setProgress(newProgress);
                if (newProgress == 100) {
                    dingyue_web_Bar.setVisibility(View.GONE);
                }
            }
        });
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // 建议缓存策略为，判断是否有网络，有的话，使用LOAD_DEFAULT,无网络时，使用LOAD_CACHE_ELSE_NETWORK
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 设置缓存模式
        // 开启DOM storage API 功能
        settings.setDomStorageEnabled(true);
        // 开启database storage API功能
        settings.setDatabaseEnabled(true);
        //缓存详细路径
        String cacheDirPath = getFilesDir().getAbsolutePath()
                + APP_CACHE_DIRNAME;
        File file = new File(cacheDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.e("cachePath", cacheDirPath);
        // 设置数据库缓存路径
        settings.setDatabasePath(cacheDirPath); // API 19 deprecated
        // 设置Application caches缓存目录
        settings.setAppCachePath(cacheDirPath);
        // 开启Application Cache功能
        settings.setAppCacheEnabled(true);
        //加载网页
        dingyue_web.loadUrl(webUrl);
        //**********************导航栏监听************************
        //回退键
        ((ImageView) findViewById(R.id.dingyue_details_back)).setOnClickListener(this);
        //评论键
        ((ImageView) findViewById(R.id.dingyue_details_pinglun)).setOnClickListener(this);
        //分享键
        share = (ImageView) findViewById(R.id.dingyue_details_share);
        share.setOnClickListener(this);
        //设置键
        ((ImageView) findViewById(R.id.dingyue_details_setting)).setOnClickListener(this);

    }

    //**********************单击监听************************
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //回退键
            case R.id.dingyue_details_back:
                finish();
                break;
            //评论键
            case R.id.dingyue_details_pinglun:
                Toast.makeText(this, "评论", Toast.LENGTH_SHORT).show();
                break;
            //分享键
            case R.id.dingyue_details_share:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                shareView = LayoutInflater.from(this).inflate(R.layout.layout_share, null);
                initShare();
                new AlertDialog.Builder(this)
                        .setView(shareView)
                        .show();
                break;
            //设置键
            case R.id.dingyue_details_setting:
//                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();

                View view = LayoutInflater.from(this).inflate(R.layout.dingyue_details_setting, null);
                //夜间模式按钮监听
                Switch nightSwitch = (Switch) view.findViewById(R.id.dingyue_setting_nightMode);
                nightSwitch.setOnCheckedChangeListener(this);
                new AlertDialog.Builder(this)
                        .setView(view)
                        .show();
                break;
            case R.id.share_qq:
                QQShare();
                break ;
            case R.id.share_qqzone:
                shareToQzone();
                break ;

        }
    }

    private void initShare() {
        shareto_topic = (TextView) shareView.findViewById(R.id.shareto_topic);
        shareto_topic.setOnClickListener(this);
        share_weixin = (TextView)shareView. findViewById(R.id.share_weixin);
        share_weixin.setOnClickListener(this);
        share_friends = (TextView)shareView. findViewById(R.id.share_friends);
        share_friends.setOnClickListener(this);
        share_sina = (TextView) shareView.findViewById(R.id.share_sina);
        share_sina.setOnClickListener(this);
        share_qq = (TextView)shareView. findViewById(R.id.share_qq);
        share_qq.setOnClickListener(this);
        share_qqzone = (TextView) shareView.findViewById(R.id.share_qqzone);
        share_qqzone.setOnClickListener(this);
        share_qq_collect = (TextView)shareView. findViewById(R.id.share_qq_collect);
        share_qq_collect.setOnClickListener(this);
        share_email = (TextView)shareView. findViewById(R.id.share_email);
        share_email.setOnClickListener(this);
        share_evernote = (TextView)shareView. findViewById(R.id.share_evernote);
        share_evernote.setOnClickListener(this);
        share_pock = (TextView)shareView. findViewById(R.id.share_pock);
        share_pock.setOnClickListener(this);
        share_kindle = (TextView)shareView. findViewById(R.id.share_kindle);
        share_kindle.setOnClickListener(this);
        share_more = (TextView) shareView.findViewById(R.id.share_more);
        share_more.setOnClickListener(this);
        share_report = (TextView)shareView. findViewById(R.id.share_report);
        share_report.setOnClickListener(this);
        share_favor = (TextView)shareView.findViewById(R.id.share_favor);
        share_favor.setOnClickListener(this);
    }

    //腾讯UI监听
    IUiListener qZoneShareListener = new IUiListener() {

        @Override
        public void onCancel() {
            QQUtil.toastMessage(DingyueDetailsActivity.this, "onCancel:test ");
        }

        @Override
        public void onError(UiError e) {
            // TODO Auto-generated method stub
            QQUtil.toastMessage(DingyueDetailsActivity.this, "onError: " + e.errorMessage, "e");
        }

        @Override
        public void onComplete(Object response) {
            // TODO Auto-generated method stub
            QQUtil.toastMessage(DingyueDetailsActivity.this, "onComplete: " + response.toString());
        }

    };

    /**
     * QQ分享
     */
    private void QQShare() {
//        //分享类型
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, title);
//        params.putString(QQShare.SHARE_TO_QQ_SUMMARY,  "要分享的摘要");
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, webUrl);
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://c.hiphotos.baidu.com/baike/w%3D268/sign=3b8de02bd443ad4ba62e41c6ba035a89/8718367adab44aedcccda36ab61c8701a08bfbb9.jpg");
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222");
        mTencent.shareToQQ(DingyueDetailsActivity.this, params, qZoneShareListener);
    }

    private void shareToQzone() {
        //分享类型
        final Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, title);//必填
//        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "摘要");//选填
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, webUrl);//必填
        ArrayList<String> imgArr = new ArrayList<>();
        imgArr.add("http://c.hiphotos.baidu.com/baike/w%3D268/sign=3b8de02bd443ad4ba62e41c6ba035a89/8718367adab44aedcccda36ab61c8701a08bfbb9.jpg");
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, imgArr);
        mTencent.shareToQzone(DingyueDetailsActivity.this, params, qZoneShareListener);
    }

    /**
     * WebView可回退
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (dingyue_web.canGoBack()) {
                dingyue_web.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 夜间模式开关监听
     *
     * @param buttonView
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Toast.makeText(this, "开启夜间模式", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "关闭夜间模式", Toast.LENGTH_SHORT).show();
        }
    }

    //腾讯SDK必需
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (null != mTencent)
            mTencent.onActivityResult(requestCode, resultCode, data);
    }
}
