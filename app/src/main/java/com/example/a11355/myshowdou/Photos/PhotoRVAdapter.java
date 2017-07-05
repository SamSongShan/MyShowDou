package com.example.a11355.myshowdou.Photos;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.a11355.myshowdou.Base.AbsRecyclerAdapter;
import com.example.a11355.myshowdou.Base.OnAdapterCallbackListener;
import com.example.a11355.myshowdou.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Random;

/**
 * Created by 11355 on 2017/7/5.
 */

public class PhotoRVAdapter extends AbsRecyclerAdapter<PhotoEntity.ResultsBean> {


    private Context context;
    private OnAdapterCallbackListener onAdapterCallbackListener;
    private int heigths[] = {400, 500, 600,700};

    public PhotoRVAdapter(Context context, OnAdapterCallbackListener onAdapterCallbackListener) {
        super(context, R.layout.item_rv_photo, R.layout.item_next_page_loading,
                R.layout.item_page_bottom);
        this.context = context;
        this.onAdapterCallbackListener = onAdapterCallbackListener;
    }

    @Override
    public int getItemType(PhotoEntity.ResultsBean d) {
        return d.getMyType();
    }

    @Override
    public void onBindHolder(AbsRecyclerAdapter.RecyclerHolder holder, PhotoEntity.ResultsBean d, int position) {
        switch (d.getMyType()) {
            case 0:
                SimpleDraweeView view = (SimpleDraweeView) holder.getView(R.id.sdv);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i = new Random().nextInt(4);
                layoutParams.height =heigths[i];
                view.setLayoutParams(layoutParams);
                holder.bindSimpleDraweeView(R.id.sdv, d.getUrl());

                break;
            case 1:
                onAdapterCallbackListener.onCallback();
                break;
        }
    }
}
