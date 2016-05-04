package com.example.lenovo.wdw.adapters;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.lenovo.wdw.R;
import com.example.lenovo.wdw.models.RedianLikeGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkk on 2016/4/13.
 */
public class RedianGridViewAdapter extends TeachBaseAdapter<RedianLikeGridView> {
    private static final String TAG = RedianGridViewAdapter.class.getSimpleName();

    public RedianGridViewAdapter(ArrayList<RedianLikeGridView> data, Context context, int... layRes) {
        super(data, context, layRes);
    }

    @Override
    public void bindData(ViewHolder holder, RedianLikeGridView redianLikeGridView,int position) {
        switch (redianLikeGridView.getType()) {
            case 0:
                TextView textView = (TextView) holder.getView(R.id.reDian_like_more_tv);
                textView.setText(redianLikeGridView.getTitle());
                break;
        }
    }
}
