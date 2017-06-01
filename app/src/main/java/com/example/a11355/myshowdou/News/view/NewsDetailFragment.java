package com.example.a11355.myshowdou.News.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailFragment extends BaseFragment {


    @Override
    protected int getViewResId() {
        return R.layout.fragment_news_detial;
    }

    public NewsDetailFragment instanceFragment(String url){
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        fragment.setArguments(bundle);
        return fragment;

    }

}
