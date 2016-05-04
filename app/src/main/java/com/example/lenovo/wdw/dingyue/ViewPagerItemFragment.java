package com.example.lenovo.wdw.dingyue;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.wdw.MyApp;
import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.DingyueViewPageModel;

import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerItemFragment extends Fragment implements View.OnClickListener {


    private ImageView viewpager_item_image;
    private ImageView viewpager_item_type;
    private TextView viewpager_item_title;
    private RelativeLayout dingyue_viewpager_layout;
    private DingyueViewPageModel.DataBean.ListBean data;

    public ViewPagerItemFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager_item, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        //获取数据对象
        data = getArguments().getParcelable("key");
        //轮播图
        viewpager_item_image = (ImageView) view.findViewById(R.id.viewpager_item_image);
        x.image().bind(viewpager_item_image, data.getPromotion_img(), MyApp.option);
        //轮播图类型
        viewpager_item_type = (ImageView) view.findViewById(R.id.viewpager_item_type);
        if (data.getTag_info() != null) {
            x.image().bind(viewpager_item_type, data.getTag_info().getImage_url(), MyApp.option);
        }
        //轮播图标题
        viewpager_item_title = (TextView) view.findViewById(R.id.viewpager_item_title);
        viewpager_item_title.setText(data.getTitle());
        //轮播图跳转监听
        dingyue_viewpager_layout = (RelativeLayout) view.findViewById(R.id.dingyue_viewpager_layout);
        dingyue_viewpager_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //如果可进入内部页面,则跳转
        if (data.getArticle() != null | data.getPost() != null | data.getTopic() != null | data.getBlock_info() != null) {
            Intent intent = null;
            //详情页
            if (data.getArticle() != null) {
                intent = new Intent(getContext(), DingyueDetailsActivity.class);
                intent.putExtra("title",data.getArticle().getTitle());
                intent.putExtra("web", data.getArticle().getWeburl());
            } else if (data.getPost() != null) {
                intent = new Intent(getContext(), DingyueDetailsActivity.class);
                intent.putExtra("web", data.getPost().getWeburl());
            } else if (data.getTopic() != null) {//Topic页面,如:十说今日
                intent = new Intent(getContext(), DingyueTopicActivity.class);
                intent.putExtra("topicUrl", data.getTopic().getApi_url());
            } else if (data.getBlock_info() != null) {
                //内容页:如频道
                intent = new Intent(getContext(), DingyueContentActivity.class);
                intent.putExtra("contentUrl", data.getBlock_info().getApi_url());
            }
            startActivity(intent);
        }
    }
}
