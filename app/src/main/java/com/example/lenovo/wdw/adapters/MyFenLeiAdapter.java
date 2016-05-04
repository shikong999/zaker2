package com.example.lenovo.wdw.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.WWeekendS;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
public class MyFenLeiAdapter extends BaseAdapter {

    private List<WWeekendS> weekendSes;
    private Context context;
    private LayoutInflater inflater;

    public MyFenLeiAdapter(List<WWeekendS> weekendSes, Context context) {
        this.weekendSes = weekendSes;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    public void UpdateRea(List<WWeekendS> weekendSes){
        if(weekendSes!=null){
            this.weekendSes.clear();
            this.weekendSes.addAll(weekendSes);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return weekendSes.size();
    }

    @Override
    public WWeekendS getItem(int position) {
        return weekendSes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler3 hodler3=null;
        if(convertView==null){
            hodler3=new ViewHodler3();
            convertView=inflater.inflate(R.layout.list_item_fenlei,parent,false);
            hodler3.imageView= (ImageView) convertView.findViewById(R.id.imageView_fen_lei);
            hodler3.textViewName= (TextView) convertView.findViewById(R.id.textView_fen_title);
            hodler3.textViewDate= (TextView) convertView.findViewById(R.id.textView_fen_date);
            convertView.setTag(hodler3);
        }else {
            hodler3= (ViewHodler3) convertView.getTag();
        }
        hodler3.textViewName.setText(getItem(position).getTitle());
        hodler3.textViewDate.setText(getItem(position).getTime_str());
        ImageLoader.getInstance().displayImage(getItem(position).getThumbnail_medias().get(0).getUrl(),hodler3.imageView);
        return convertView;
    }
    static class ViewHodler3{
        ImageView imageView;
        TextView textViewName;
        TextView textViewDate;
    }
}
