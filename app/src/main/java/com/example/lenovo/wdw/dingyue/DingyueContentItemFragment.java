package com.example.lenovo.wdw.dingyue;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.wdw.MyApp;
import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.DingyueContentModel;

import org.xutils.x;

/**
 * 订阅内容条目
 */
public class DingyueContentItemFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = DingyueContentItemFragment.class.getSimpleName();
    //条目1
    private ImageView dingyue_content_item_one_image;
    private TextView dingyue_content_item_one_title;
    //条目2
    private TextView dingyue_content_item_two_title;
    private TextView dingyue_content_item_two_auther;
    //条目3
    private TextView dingyue_content_item_three_title;
    private TextView dingyue_content_item_three_auther;
    //条目4
    private TextView dingyue_content_item_four_title;
    private TextView dingyue_content_item_four_auther;
    //条目5
    private TextView dingyue_content_item_five_title;
    private TextView dingyue_content_item_five_auther;
    //条目6
    private TextView dingyue_content_item_six_title;
    private TextView dingyue_content_item_six_auther;
    private LinearLayout dingyue_content_item_two;
    private LinearLayout dingyue_content_item_three;
    private LinearLayout dingyue_content_item_four;
    private LinearLayout dingyue_content_item_five;
    private LinearLayout dingyue_content_item_six;
    //条目1数据
    private DingyueContentModel.DataBean.ArticlesBean news1;
    //条目2数据
    private DingyueContentModel.DataBean.ArticlesBean news2;
    //条目3数据
    private DingyueContentModel.DataBean.ArticlesBean news3;
    //条目4数据
    private DingyueContentModel.DataBean.ArticlesBean news4;
    //条目5数据
    private DingyueContentModel.DataBean.ArticlesBean news5;
    //条目6数据
    private DingyueContentModel.DataBean.ArticlesBean news6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dingyue_content_item, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        Bundle bundle = getArguments();
        String topImgUrl = bundle.getString("topImg");
        //第一条信息
        news1 = bundle.getParcelable("news0");
        Log.e(TAG, news1.getTitle());
        //第二条信息
        news2 = bundle.getParcelable("news1");
        //第三条信息
        news3 = bundle.getParcelable("news2");
        //第四条信息
        news4 = bundle.getParcelable("news3");
        //第五条信息
        news5 = bundle.getParcelable("news4");
        //第六条信息
        news6 = bundle.getParcelable("news5");
        //设置头部图片
        ImageView topImage = (ImageView) view.findViewById(R.id.dingyue_content_top);
        x.image().bind(topImage, topImgUrl,MyApp.option);
        //********************//设置第1条信息的内容********************************
        dingyue_content_item_one_image = (ImageView) view.findViewById(R.id.dingyue_content_item_one_image);
        dingyue_content_item_one_image.setOnClickListener(this);
        if (news1.getMedia().size() > 0) {
            x.image().bind(dingyue_content_item_one_image, news1.getMedia().get(0).getUrl(), MyApp.option);
        } else {
            dingyue_content_item_one_image.setImageResource(R.mipmap.sns_guide_login_main_collect);
        }
        dingyue_content_item_one_title = (TextView) view.findViewById(R.id.dingyue_content_item_one_title);
        dingyue_content_item_one_title.setText(news1.getTitle());
        //********************//设置第2条信息的内容********************************
        dingyue_content_item_two_title = (TextView) view.findViewById(R.id.dingyue_content_item_two_title);
        dingyue_content_item_two_title.setText(news2.getTitle());
        dingyue_content_item_two_auther = (TextView) view.findViewById(R.id.dingyue_content_item_two_auther);
        dingyue_content_item_two_auther.setText(news2.getAuther_name());
        //***********************//设置第3条信息的内容*****************************
        dingyue_content_item_three_title = (TextView) view.findViewById(R.id.dingyue_content_item_three_title);
        dingyue_content_item_three_title.setText(news3.getTitle());
        dingyue_content_item_three_auther = (TextView) view.findViewById(R.id.dingyue_content_item_three_auther);
        dingyue_content_item_three_auther.setText(news3.getAuther_name());
        //************************//设置第4条信息的内容****************************
        dingyue_content_item_four_title = (TextView) view.findViewById(R.id.dingyue_content_item_four_title);
        dingyue_content_item_four_title.setText(news4.getTitle());
        dingyue_content_item_four_auther = (TextView) view.findViewById(R.id.dingyue_content_item_four_auther);
        dingyue_content_item_four_auther.setText(news4.getAuther_name());
        //************************//设置第5条信息的内容****************************
        dingyue_content_item_five_title = (TextView) view.findViewById(R.id.dingyue_content_item_five_title);
        dingyue_content_item_five_title.setText(news5.getTitle());
        dingyue_content_item_five_auther = (TextView) view.findViewById(R.id.dingyue_content_item_five_auther);
        dingyue_content_item_five_auther.setText(news5.getAuther_name());
        //************************//设置第6条信息的内容****************************
        dingyue_content_item_six_title = (TextView) view.findViewById(R.id.dingyue_content_item_six_title);
        dingyue_content_item_six_title.setText(news6.getTitle());
        dingyue_content_item_six_auther = (TextView) view.findViewById(R.id.dingyue_content_item_six_auther);
        dingyue_content_item_six_auther.setText(news6.getAuther_name());
        //第一个条目用图片跳转
        dingyue_content_item_two = (LinearLayout) view.findViewById(R.id.dingyue_content_item_two);
        dingyue_content_item_two.setOnClickListener(this);
        dingyue_content_item_three = (LinearLayout) view.findViewById(R.id.dingyue_content_item_three);
        dingyue_content_item_three.setOnClickListener(this);
        dingyue_content_item_four = (LinearLayout) view.findViewById(R.id.dingyue_content_item_four);
        dingyue_content_item_four.setOnClickListener(this);
        dingyue_content_item_five = (LinearLayout) view.findViewById(R.id.dingyue_content_item_five);
        dingyue_content_item_five.setOnClickListener(this);
        dingyue_content_item_six = (LinearLayout) view.findViewById(R.id.dingyue_content_item_six);
        dingyue_content_item_six.setOnClickListener(this);
    }

    /**
     * 跳转详情页的方法
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), DingyueDetailsActivity.class);
        switch (v.getId()) {
            case R.id.dingyue_content_item_one_image:
                Animator animator= ViewAnimationUtils.createCircularReveal(v, v.getWidth() / 2, v.getHeight() / 2, 1, Math.min(v.getWidth(),v.getHeight()/2));
                animator.setDuration(100);
                animator.start();
                Intent intent1 = new Intent(getContext(), DingyueDetailsActivity.class);
                intent.putExtra("title", news1.getTitle());
                intent.putExtra("web", news1.getWeburl());
                startActivity(intent1);
                break;
            case R.id.dingyue_content_item_two:
                if (news2 != null) {
                    intent.putExtra("title",news2.getTitle());
                    intent.putExtra("web", news2.getWeburl());
                }
                break;
            case R.id.dingyue_content_item_three:
                if (news3 != null) {
                    intent.putExtra("title",news3.getTitle());
                    intent.putExtra("web", news3.getWeburl());
                }
                break;
            case R.id.dingyue_content_item_four:
                if (news4 != null) {
                    intent.putExtra("title",news4.getTitle());
                    intent.putExtra("web", news4.getWeburl());
                }
                break;
            case R.id.dingyue_content_item_five:
                if (news5 != null) {
                    intent.putExtra("title",news5.getTitle());
                    intent.putExtra("web", news5.getWeburl());
                }
                break;
            case R.id.dingyue_content_item_six:
                if (news6 != null) {
                    intent.putExtra("title",news6.getTitle());
                    intent.putExtra("web", news6.getWeburl());
                }
                break;

        }
        //跳转到详情页
        startActivity(intent);
    }
}
