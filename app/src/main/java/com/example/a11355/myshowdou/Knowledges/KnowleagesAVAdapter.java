package com.example.a11355.myshowdou.Knowledges;

import android.content.Context;

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

    @Override
    public void onBindHolder(AbsRecyclerAdapter.RecyclerHolder holder, KnowlegesEntity.ResultsBean d, int position) {

    }
}
