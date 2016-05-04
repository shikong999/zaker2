package com.example.lenovo.wdw.redian;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.adapters.RedianLikeViewPagerAdapter;
import com.example.lenovo.wdw.fragments.RedianViewPagerFragmentMine;
import com.example.lenovo.wdw.fragments.RedianViewPagerFragmentMore;

import java.util.ArrayList;
import java.util.List;

public class RedianLikeActivity extends AppCompatActivity implements View.OnClickListener, RedianViewPagerFragmentMine.ViewPagerListener {

    private TabLayout reian_like_tabLayout;
    private ViewPager reDian_like_viewPager;
    private Button reDian_like_sure;
    private ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redian_like);
        initView();
    }

    private void initView() {

        reian_like_tabLayout = (TabLayout) findViewById(R.id.reian_like_tabLayout);
        //设置TabLayout的条目如果没有充满整个屏幕就占满整个屏幕
        reian_like_tabLayout.setTabMode(TabLayout.MODE_FIXED);
        reDian_like_viewPager = (ViewPager) findViewById(R.id.reDian_like_viewPager);
        reDian_like_sure = (Button) findViewById(R.id.reDian_like_sure);
        back = ((ImageView) findViewById(R.id.reDIan_biaoqian_back));
        back.setOnClickListener(this);
        reDian_like_sure.setOnClickListener(this);
        List<Fragment> data = new ArrayList<>();
        RedianViewPagerFragmentMine redianViewPagerFragmentMine = new RedianViewPagerFragmentMine();
        redianViewPagerFragmentMine.setViewPagerListener(this);
        data.add(redianViewPagerFragmentMine);
        data.add(new RedianViewPagerFragmentMore());
        List<String> titles = new ArrayList<>();
        titles.add("你的偏好");
        titles.add("添加更多偏好");
        RedianLikeViewPagerAdapter redianLikeViewPagerAdapter = new RedianLikeViewPagerAdapter(getSupportFragmentManager(), data, titles);
        reDian_like_viewPager.setAdapter(redianLikeViewPagerAdapter);
        reian_like_tabLayout.setupWithViewPager(reDian_like_viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reDian_like_sure:
                finish();
                break;
            case R.id.reDIan_biaoqian_back:
                finish();
                break;
        }
    }

    @Override
    public void pageChanged(int page) {
        reDian_like_viewPager.setCurrentItem(page);
    }
}
