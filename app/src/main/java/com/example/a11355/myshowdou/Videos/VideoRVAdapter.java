package com.example.a11355.myshowdou.Videos;

import android.content.Context;

import com.example.a11355.myshowdou.Base.AbsRecyclerAdapter;
import com.example.a11355.myshowdou.Base.OnAdapterCallbackListener;
import com.example.a11355.myshowdou.R;

/**
 * Created by 11355 on 2017/6/12.
 */

public class VideoRVAdapter extends AbsRecyclerAdapter<VideoListEntity.DataBean> {

    private Context context;
    private OnAdapterCallbackListener onAdapterCallbackListener;

    public VideoRVAdapter(Context context, OnAdapterCallbackListener onAdapterCallbackListener) {
        super(context, R.layout.item_rv_videofragement, R.layout.item_next_page_loading,
                R.layout.item_page_bottom);
        this.context = context;
        this.onAdapterCallbackListener = onAdapterCallbackListener;
    }

    @Override
    public int getItemType(VideoListEntity.DataBean d) {
        return d.getType();
    }

    @Override
    public void onBindHolder(AbsRecyclerAdapter.RecyclerHolder holder, VideoListEntity.DataBean d, int position) {

        switch (d.getType()) {
            case 0:
                holder.bindSimpleDraweeView(R.id.sdv, d.getCover())
                        .bindTextView(R.id.tv_title, d.getTitle())
                        .bindSimpleDraweeView(R.id.sdv_from, d.getTopicImg())
                        .bindTextView(R.id.tv_from, d.getTopicName());
                break;
            case 1:
                onAdapterCallbackListener.onCallback();
                break;

        }


    }
}
