package com.example.lenovo.wdw.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dkk on 2016/4/12.
 */
public class RedianLikeViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private List<String> titles;

    public RedianLikeViewPagerAdapter(FragmentManager fm, List<Fragment> data, List<String> titles) {
        super(fm);
        this.data = data;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
