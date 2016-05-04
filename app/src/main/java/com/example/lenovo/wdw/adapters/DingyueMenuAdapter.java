package com.example.lenovo.wdw.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.DingyueMenuModel;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 订阅主页面菜单适配器
 */
public class DingyueMenuAdapter extends BaseAdapter  {

    private List<DingyueMenuModel.DataBean.BlocksDataBean> data;
    private LayoutInflater inflater;

    //构造
    public DingyueMenuAdapter(Context context, List<DingyueMenuModel.DataBean.BlocksDataBean> data) {
        if (data == null) {
            this.data = new ArrayList<>();
        } else {
            this.data = data;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //更新数据源
    public void updateRes(List<DingyueMenuModel.DataBean.BlocksDataBean> data) {
        if (data != null && data.size() > 0) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    //添加数据源
    public void addRes(List<DingyueMenuModel.DataBean.BlocksDataBean> data) {
        if (data != null && data.size() > 0) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    //为在最后添加固定条目,count+1
    @Override
    public int getCount() {
        return data != null ? data.size() + 1 : 0;
    }

    @Override
    public DingyueMenuModel.DataBean.BlocksDataBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder=new ViewHolder();
            convertView = inflater.inflate(R.layout.dingyue_grid_menu_item, parent, false);
            holder.image = (ImageView) convertView.findViewById(R.id.dingyue_grid_item_image);
            holder.title = (TextView) convertView.findViewById(R.id.dingyue_grid_item_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        /**
         * 适配数据
         */
        //如果为最后一个条目,则固定为添加选项
        if (position == getCount()-1) {
            holder.image.setImageResource(R.mipmap.box_add_icon);
            holder.title.setText("添加更多");
        } else {
            x.image().bind(holder.image, getItem(position).getPic());
            holder.title.setText(getItem(position).getTitle());
        }
        return convertView;
    }



    private class ViewHolder {
        private ImageView image;
        private TextView title;
    }
}
