package com.example.lenovo.wdw.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.WList;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
public class MyGridViewAdapter extends BaseAdapter{

    private List<WList> list;
    private Context context;

    public MyGridViewAdapter(List<WList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void updateRes(List<WList> list){
        if (list != null){
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public WList getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            holder.feilei_icon= (ImageView) convertView.findViewById(R.id.feilei_icon);
            holder.feilei_name= (TextView) convertView.findViewById(R.id.feilei_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.feilei_name.setText(list.get(position).getCategory());
        ImageLoader.getInstance().displayImage(list.get(position).getIcon(),holder.feilei_icon);
        return convertView;
    }
    private static class ViewHolder{
        ImageView feilei_icon;
        TextView feilei_name;
    }
}
