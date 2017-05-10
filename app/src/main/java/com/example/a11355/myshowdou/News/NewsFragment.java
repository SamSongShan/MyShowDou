package com.example.a11355.myshowdou.News;


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
public class NewsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    Unbinder unbinder;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void init(View v) {
        srl.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {

    }
}
