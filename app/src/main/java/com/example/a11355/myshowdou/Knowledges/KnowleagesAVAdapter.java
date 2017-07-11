package com.example.a11355.myshowdou.Knowledges;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.a11355.myshowdou.Base.AbsRecyclerAdapter;
import com.example.a11355.myshowdou.Base.OnAdapterCallbackListener;
import com.example.a11355.myshowdou.R;

/**
 * Created by 11355 on 2017/7/6.
 */

public class KnowleagesAVAdapter extends AbsRecyclerAdapter<KnowlegesEntity.ResultsBean> {
    private Context context;
    private OnAdapterCallbackListener onAdapterCallbackListener;

    public KnowleagesAVAdapter(Context context, OnAdapterCallbackListener onAdapterCallbackListener) {
        super(context, R.layout.item_rv_newsfragement, R.layout.item_next_page_loading,
                R.layout.item_page_bottom);
        this.context = context;
        this.onAdapterCallbackListener = onAdapterCallbackListener;
    }

    @Override
    public int getItemType(KnowlegesEntity.ResultsBean d) {
        return d.getMyType();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindHolder(AbsRecyclerAdapter.RecyclerHolder holder, KnowlegesEntity.ResultsBean d, int position) {
        switch (d.getMyType()) {
            case 0:
                if (d.getImages() == null) {
                    holder.bindSimpleDraweeView(R.id.sdv, R.mipmap.ic_launcher)
                            .bindTextView(R.id.tv_title, d.getDesc())
                            .bindTextView(R.id.tv_content, d.getType() + " " + d.getWho());
                } else {
                    holder.bindSimpleDraweeView(R.id.sdv, d.getImages().get(0))
                            .bindTextView(R.id.tv_title, d.getDesc())
                            .bindTextView(R.id.tv_content, d.getType() + " " + d.getWho());
                }


                break;
            case 1:
                onAdapterCallbackListener.onCallback();
                break;

        }
    }
}
