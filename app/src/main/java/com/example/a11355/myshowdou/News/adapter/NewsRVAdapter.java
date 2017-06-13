package com.example.a11355.myshowdou.News.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.example.a11355.myshowdou.Base.AbsRecyclerAdapter;
import com.example.a11355.myshowdou.Base.OnAdapterCallbackListener;
import com.example.a11355.myshowdou.News.bean.NewsListEntity;
import com.example.a11355.myshowdou.R;

/**
 * Created by 11355 on 2017/6/12.
 */

public class NewsRVAdapter extends AbsRecyclerAdapter<NewsListEntity.DataBean> {

    private Context context;
    private OnAdapterCallbackListener onAdapterCallbackListener;

    public NewsRVAdapter(Context context, OnAdapterCallbackListener onAdapterCallbackListener) {
        super(context, R.layout.item_rv_newsfragement,R.layout.item_rv_newsfragement_photo, R.layout.item_next_page_loading,
                R.layout.item_page_bottom);
        this.context = context;
        this.onAdapterCallbackListener = onAdapterCallbackListener;
    }

    @Override
    public int getItemType(NewsListEntity.DataBean d) {
        if (d.getImgextra()!=null){
            d.setType(1);
        }

        return d.getType();
    }

    @Override
    public void onBindHolder(AbsRecyclerAdapter.RecyclerHolder holder, NewsListEntity.DataBean d, int position) {

        switch (d.getType()){
            case 0:
                holder.setItemTag(R.id.tag_relation,d.getPostid())
                        .bindSimpleDraweeView(R.id.sdv,d.getImgsrc())
                        .bindTextView(R.id.tv_title,TextUtils.isEmpty(d.getLtitle())?d.getTitle():d.getLtitle())
                        .bindTextView(R.id.tv_content,TextUtils.isEmpty(d.getDigest())?d.getVideosource():d.getDigest());
                break;
            case 1:
                holder.setItemTag(R.id.tag_relation2,d.getPostid())
                        .bindSimpleDraweeView(R.id.sdv,d.getImgextra().get(0).getImgsrc())
                        .bindTextView(R.id.tv_title,TextUtils.isEmpty(d.getLtitle())?d.getTitle():d.getLtitle())
                        .bindSimpleDraweeView(R.id.sdv1,d.getImgextra().get(1).getImgsrc());
                break;
            case 2:
                onAdapterCallbackListener.onCallback();
                break;

        }


    }
}
