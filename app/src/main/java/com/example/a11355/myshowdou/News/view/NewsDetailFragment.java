package com.example.a11355.myshowdou.News.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.R;
import com.example.a11355.myshowdou.Utils.Constant;
import com.example.a11355.myshowdou.Utils.OkHttpUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailFragment extends BaseFragment implements OkHttpUtil.OnDataListener {


    private String url;
    private int startPage=0;
    private int endPage=10;


    @Override
    protected int getViewResId() {
        return R.layout.fragment_news_detial;
    }

    public static NewsDetailFragment instanceFragment(String url){
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    protected void init(View v) {
        url = getArguments().getString("url");

    }

    @Override
    protected void loadData() {
        OkHttpUtil.getJSON(String.format(Constant.URL.TOP_URL+url+Constant.URL.END_URL,startPage,endPage),this);
    }

    @Override
    public void onResponse(String url, String json) {
        if (!TextUtils.isEmpty(json)){
            Log.e("loge", "onResponse: "+json);
        }
    }

    @Override
    public void onFailure(String url, String error) {

    }
}
