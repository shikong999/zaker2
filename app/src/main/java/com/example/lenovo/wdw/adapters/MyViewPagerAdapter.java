package com.example.lenovo.wdw.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wucheng on 2016/4/11.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        if (data == null) {
            this.data=new ArrayList<>();
        }else {
            this.data=data;
        }
    }

    public  void addDate(List<Fragment> data){
        if (data!=null&&data.size()>0){
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public  void updateRes(List<Fragment> data){
        if (data!=null&&data.size()>0){
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }
}
