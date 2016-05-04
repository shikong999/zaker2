package com.example.lenovo.wdw.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.nostra13.universalimageloader.core.ImageLoader;


import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/4/12.
 */
public class MyListViewAdapter extends BaseAdapter {

    private List<Object> listContent;
    private Context context;
    private LayoutInflater inflater;

    final int TYPE_1 = 0;
    final int TYPE_2 = 1;

    public MyListViewAdapter(List<Object> listContent, Context context) {
        this.listContent = listContent;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    public void updateRes(List<Object> listContent){
        if(listContent!=null){
            this.listContent.clear();
            this.listContent.addAll(listContent);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return listContent!=null?listContent.size():0;
    }

    @Override
    public Object getItem(int position) {
        return listContent.get(position);
    }

    @Override
    public long getItemId(int position) {



        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int p=position%6;
        if(p==0){
            return TYPE_1;
        }else if(p<6){
                return TYPE_2;
        }else {
            return TYPE_1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        ViewHolder1 holder1 = null;
        int type=getItemViewType(position);
        if(convertView==null){
            switch (type){
                case -1:
                    convertView=null;
                    break;
                case TYPE_1:
                    convertView=inflater.inflate(R.layout.list_item_date,parent,false);
                    holder1=new ViewHolder1();
                    holder1.imageViewDate= (ImageView) convertView.findViewById(R.id.image_date);
                    convertView.setTag(holder1);
                    break;
                case TYPE_2:
                    convertView=inflater.inflate(R.layout.list_itme,parent,false);
                    holder=new ViewHolder();
                    holder.textViewName= (TextView) convertView.findViewById(R.id.text_title);
                    holder.textViewContent=(TextView)convertView.findViewById(R.id.text_title_two);
                    holder.imageView=(ImageView)convertView.findViewById(R.id.image_list);
                    holder.imageView.setAlpha(100);
                    convertView.setTag(holder);
                    break;
                default:
                    break;
            }
        }else {
            switch (type){
                case -1:
                    convertView=null;
                    break;
                case TYPE_1:
                    holder1= (ViewHolder1) convertView.getTag();
                    break;
                case TYPE_2:
                    holder= (ViewHolder) convertView.getTag();
                    break;
            }
        }
        switch (type){
            case -1:
                convertView=null;
                break;
            case TYPE_1:
                ImageLoader.getInstance().displayImage(listContent.get(position).toString(),holder1.imageViewDate);
                break;
            case TYPE_2:
                holder.textViewName.setText(((HashMap<String,String>)listContent.get(position)).get("title"));
                holder.textViewContent.setText(((HashMap<String,String>)listContent.get(position)).get("content"));
                ImageLoader.getInstance().displayImage(((HashMap<String,String>)listContent.get(position)).get("url"),holder.imageView);
                break;
        }
        return convertView;
    }
    static class ViewHolder1{
        ImageView imageViewDate;
    }
    static class ViewHolder{
        ImageView imageView;
        TextView textViewName;
        TextView textViewContent;
    }
}
