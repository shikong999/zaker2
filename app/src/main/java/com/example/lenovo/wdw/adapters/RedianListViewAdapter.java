package com.example.lenovo.wdw.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.RedianInListView;
import com.example.lenovo.wdw.models.RedianListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkk on 2016/4/11.
 */
public class RedianListViewAdapter extends TeachBaseAdapter<RedianListView> {

    private static final String TAG = RedianListViewAdapter.class.getSimpleName();


    public RedianListViewAdapter(ArrayList<RedianListView> data, Context context, int... layRes) {
        super(data, context, layRes);
    }

    @Override
    public void bindData(ViewHolder holder, RedianListView redianListView, final int position) {
//        switch (redianListView.getType()) {
//            case 0:
//        TextView titleOne = (TextView) holder.getView(R.id.reDian_listView_itemOne_tv);
//        titleOne.setText(redianListView.getLtitle());
//        Log.e(TAG,"title"+redianListView.getLtitle());
//        ImageView imageOne = (ImageView) holder.getView(R.id.reDian_listView_itemOne_image);
//        x.image().bind(imageOne, redianListView.getUrl());


//                break;
//            case 1:
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setUseMemCache(true)
                .setCrop(true)
                .setFailureDrawableId(R.mipmap.photo_default_img_night)
                .setLoadingDrawableId(R.mipmap.image_download)
                .build();
        ImageView imageTwo = (ImageView) holder.getView(R.id.reDian_listView_itemTwo_image);
        TextView titleTwo = (TextView) holder.getView(R.id.reDian_listView_itemTwo_tv);
        TextView digest = (TextView) holder.getView(R.id.reDian_listView_itemtwo_tv_digest);
        TextView source = (TextView) holder.getView(R.id.reDian_listView_itemtwo_tv_source);
        TextView lmodify = (TextView) holder.getView(R.id.reDian_listView_itemtwo_tv_lmodify);
        titleTwo.setText(redianListView.getLtitle());
        digest.setText(redianListView.getDigest());
        source.setText(redianListView.getSource());
        lmodify.setText(redianListView.getLmodify());
        x.image().bind(imageTwo, redianListView.getImgsrc(), imageOptions);
//                break;
//        }
    }
}
