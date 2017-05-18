package com.example.a11355.myshowdou.News.view;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.Base.BasePresenter;
import com.example.a11355.myshowdou.R;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,NewsView  {

/*
* 新闻
*
* */
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

    @Override
    public void LoadData() {

    }

    @Override
    public void getPresenter(BasePresenter p) {
        p.attachView(this);
    }


}
