package com.example.lenovo.wdw.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.redian.RedianLikeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedianViewPagerFragmentMine extends Fragment implements View.OnClickListener {

    private ViewPagerListener viewPagerListener;

    public RedianViewPagerFragmentMine() {
        // Required empty public constructor
    }

    public void setViewPagerListener(ViewPagerListener viewPagerListener) {
        this.viewPagerListener = viewPagerListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_redian_view_pager_fragment_mine, container, false);
        Button add = (Button) view.findViewById(R.id.redian_like_mine_button);
        add.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.redian_like_mine_button:
                viewPagerListener.pageChanged(1);
                break;
        }
    }

    public interface ViewPagerListener {
         void pageChanged(int page);
    }
}
