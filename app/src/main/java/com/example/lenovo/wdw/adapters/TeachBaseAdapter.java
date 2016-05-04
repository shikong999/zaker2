package com.example.lenovo.wdw.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Create by dkk on 2016/4/11.
 */
public abstract class TeachBaseAdapter<T> extends BaseAdapter {
    private ArrayList<T> data;
    private int[] layRes;
    private LayoutInflater inflater;

    public TeachBaseAdapter(ArrayList<T> data, Context context, int... layRes) {
        if (data == null) {
            this.data = new ArrayList<>();
        } else {
            this.data = data;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layRes = layRes;
    }

    public void updataData(ArrayList<T> data) {
        if (data != null && data.size() > 0) {
            this.data.clear();
            this.data = data;
            notifyDataSetChanged();
        }
    }

    public void addData(ArrayList<T> data) {
        if (data != null && data.size() > 0) {
            this.data = data;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        T t = getItem(position);
        Class<?> cls = t.getClass();
        try {
            Field field = cls.getDeclaredField("type");
            field.setAccessible(true);
            type = field.getInt(t);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return layRes.length;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public abstract void bindData(ViewHolder holder, T t, int positon);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            int itemViewType = getItemViewType(position);
            int layout = layRes[itemViewType];
            convertView = inflater.inflate(layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //设置数据源
        bindData(holder, getItem(position), position);
        return convertView;
    }

    class ViewHolder {
        private View layout;
        private HashMap<Integer, View> cacheView;

        public ViewHolder(View convertView) {
            layout = convertView;
            cacheView = new HashMap<>();
        }

        public View getView(int resId) {
            View view = null;
            if (cacheView.containsKey(resId)) {
                view = cacheView.get(resId);
            } else {
                view = layout.findViewById(resId);
                cacheView.put(resId, view);
            }
            return view;
        }
    }
}
