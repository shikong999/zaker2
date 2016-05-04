package com.example.lenovo.wdw;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * Created by Wucheng on 2016/4/11.
 */
public class MyApp extends Application {
    public static ImageOptions option;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xUtils
        x.Ext.init(this);
        option=new ImageOptions.Builder()
                .setFadeIn(true)
                .setUseMemCache(true)//允许缓存
                .setLoadingDrawableId(R.mipmap.image_download)
                .build();
        initImageLoader();
    }


    private void initImageLoader() {
        DisplayImageOptions imageOptions=new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .build();

        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(imageOptions)
                .build();

        ImageLoader.getInstance().init(configuration);
    }
}
