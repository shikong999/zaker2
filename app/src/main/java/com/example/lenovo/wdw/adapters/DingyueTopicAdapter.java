package com.example.lenovo.wdw.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.wdw.MyApp;
import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.DingyueContentModel;

import org.xutils.x;

import java.util.List;

/**
 * Created by Wucheng on 2016/4/14.
 */
public class DingyueTopicAdapter extends MyBaseAdapter<DingyueContentModel.DataBean.ArticlesBean> {
    public DingyueTopicAdapter(Context context, List<DingyueContentModel.DataBean.ArticlesBean> data, int... layouts) {
        super(context, data, layouts);
    }

    @Override
    public void bindData(ViewHolder holder, DingyueContentModel.DataBean.ArticlesBean articlesBean) {
        TextView topicTitle= (TextView) holder.getView(R.id.dingyue_topic_item_title);
        topicTitle.setText(articlesBean.getTitle());
        TextView topicAuther = (TextView) holder.getView(R.id.dingyue_topic_item_auther);
        topicAuther.setText(articlesBean.getAuther_name());
        ImageView topicImg= (ImageView) holder.getView(R.id.dingyue_topic_item_image);
        if (articlesBean.getMedia().size()>0){
            topicImg.setVisibility(View.VISIBLE);
            x.image().bind(topicImg,articlesBean.getMedia().get(0).getUrl(), MyApp.option);
        }

    }
}
