package com.example.lenovo.wdw.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.lenovo.wdw.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShequFragment extends Fragment {
    public  static final String TAG= ShequFragment.class.getSimpleName();

    public ShequFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //通知栏颜色与背景同步
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        return inflater.inflate(R.layout.fragment_shequ, container, false);
    }

}
