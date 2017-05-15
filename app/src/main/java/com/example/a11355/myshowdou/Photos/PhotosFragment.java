package com.example.a11355.myshowdou.Photos;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.R;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

/*
* 图片
*
* */
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    Unbinder unbinder;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_photos;
    }

    @Override
    protected void init(View v) {

        srl.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {

    }
}
