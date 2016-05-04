package com.example.lenovo.wdw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.wdw.fragments.DingyueFragment;
import com.example.lenovo.wdw.fragments.RedianFragment;
import com.example.lenovo.wdw.fragments.ShequFragment;
import com.example.lenovo.wdw.fragments.WanleFragment;

import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout main_fragment;
    private RadioGroup controller;
    private FragmentTransaction transaction;
    private FragmentManager fm;
    private Fragment cacheFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getSupportActionBar().hide();修改为清单文件设置,所以页面都生效
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //开启进Logo
        goLogo();
        initView();
    }

    private void initView() {
        controller = ((RadioGroup) findViewById(R.id.controller));
        controller.setOnCheckedChangeListener(this);
        main_fragment = (FrameLayout) findViewById(R.id.main_fragment);
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        cacheFragment = new DingyueFragment();
        transaction.add(R.id.main_fragment, cacheFragment, new DingyueFragment().TAG);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.dingYue:
                swithPage(new DingyueFragment().TAG, DingyueFragment.class);
                break;
            case R.id.reDian:
                swithPage(new RedianFragment().TAG, RedianFragment.class);
                break;
            case R.id.wanLe:
                swithPage(new WanleFragment().TAG, WanleFragment.class);
                break;
            case R.id.sheQu:
                swithPage(new ShequFragment().TAG, ShequFragment.class);
                break;
        }
    }

    private void swithPage(String tag, Class<? extends Fragment> cls) {
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        if (cacheFragment != null) {
            transaction.hide(cacheFragment);
        }
        cacheFragment = fm.findFragmentByTag(tag);
        if (cacheFragment != null) {
            transaction.show(cacheFragment);
        } else {
            try {
                cacheFragment = cls.getConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            transaction.add(R.id.main_fragment, cacheFragment, tag);
        }
        transaction.commit();

    }

    /**
     * 开启进Logo
     */
    private void goLogo() {
        //判断是否进入过Logo
        boolean isLogo = getIntent().getBooleanExtra("logo", false);
        //没有,则进入
        if (!isLogo){
            startActivity(new Intent(this,LogoActivity.class));
            finish();
        }
    }

    /**
     * 2次点击退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    private boolean isExite;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //如果按下的键是返回键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //如果处于可退出状态
            if (isExite) {
                //调用系统的返回键退出
                return super.onKeyDown(keyCode, event);
            } else {
                //先将退出标识设为可退出状态
                isExite = true;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //定时器
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //按过返回键后,如果2秒后没继续按返回,则重置为不可退出状态
                        isExite = false;
                    }
                }, 2000);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
