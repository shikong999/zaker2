package com.example.lenovo.wdw.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.adapters.RedianGridViewAdapter;
import com.example.lenovo.wdw.models.RedianLikeGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedianViewPagerFragmentMore extends Fragment implements View.OnClickListener {


    private RedianGridViewAdapter redianGridViewAdapter;

    public RedianViewPagerFragmentMore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_redian_view_pager_fragment_more, container, false);
        EditText editText = (EditText) view.findViewById(R.id.reDian_more_edit_like);

        TextView change = (TextView) view.findViewById(R.id.reDian_more_tv_add);
        change.setOnClickListener(this);
        GridView gridView = (GridView) view.findViewById(R.id.reDian_more_gridview);
        redianGridViewAdapter = new RedianGridViewAdapter(getData(), getActivity(), R.layout.redian_more_gridview_item);
        if (editText.getText() != null) {
            String s = editText.getText().toString();
            //跳转到另一页面把数据传过去
        }
        gridView.setAdapter(redianGridViewAdapter);
        return view;
    }

    private ArrayList<RedianLikeGridView> getData() {
        ArrayList<RedianLikeGridView> redianLikeGridViews = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RedianLikeGridView redianLikeGridView = new RedianLikeGridView();
            redianLikeGridView.setType(0);
            redianLikeGridView.setTitle("旅游" + i);
            redianLikeGridViews.add(redianLikeGridView);
        }
        return redianLikeGridViews;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reDian_more_tv_add:
                ArrayList<RedianLikeGridView> redianLikeGridViews = new ArrayList<>();
                for (int i = 10; i < 20; i++) {
                    RedianLikeGridView redianLikeGridView = new RedianLikeGridView();
                    redianLikeGridView.setType(0);
                    redianLikeGridView.setTitle("旅游" +i);
                    redianLikeGridViews.add(redianLikeGridView);
                }
                redianGridViewAdapter.updataData(redianLikeGridViews);
                break;
        }
    }
}
