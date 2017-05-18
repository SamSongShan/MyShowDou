package com.example.a11355.myshowdou.Knowledges;


import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.News.view.NewsView;
import com.example.a11355.myshowdou.R;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 技术
 */
public class KnowledgesFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener ,NewsView{


    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    Unbinder unbinder;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_knowledges;
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
}
