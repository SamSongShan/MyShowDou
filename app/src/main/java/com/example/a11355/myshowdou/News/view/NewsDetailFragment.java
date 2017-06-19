package com.example.a11355.myshowdou.News.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.a11355.myshowdou.Base.AbsRecyclerAdapter;
import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.Base.OnAdapterCallbackListener;
import com.example.a11355.myshowdou.News.adapter.NewsRVAdapter;
import com.example.a11355.myshowdou.News.bean.NewsListEntity;
import com.example.a11355.myshowdou.R;
import com.example.a11355.myshowdou.Utils.Constant;
import com.example.a11355.myshowdou.Utils.OkHttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import dmax.dialog.SpotsDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailFragment extends BaseFragment implements OkHttpUtil.OnDataListener, OnAdapterCallbackListener, AbsRecyclerAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    private String url;
    private int startPage = 0;
    private int endPage = 10;
    private NewsRVAdapter newsRVAdapter;
    private Gson gson = new GsonBuilder().create();

    private List<NewsListEntity.DataBean> dataBeen = new ArrayList<>();
    private SpotsDialog loadingDialog;


    @Override
    protected int getViewResId() {
        return R.layout.fragment_news_detial;
    }

    public static NewsDetailFragment instanceFragment(String url) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    protected void init(View v) {
        url = getArguments().getString("url");
        newsRVAdapter = new NewsRVAdapter(getActivity(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(newsRVAdapter);
        newsRVAdapter.setOnItemClickListener(this);
        srl.setOnRefreshListener(this);

    }

    @Override
    protected void loadData() {
        loadingDialog = new SpotsDialog(getActivity(), "加载中...", R.style.Loading);
        loadingDialog.show();
        if (srl != null && srl.isRefreshing()) {
            srl.setRefreshing(false);
        }

        OkHttpUtil.getJSON(String.format(Constant.URL.TOP_URL + url + Constant.URL.END_URL, startPage, endPage), this);
    }

    @Override
    public void onResponse(String url, String json) {
        dismissLoading();
        removeLoadItem();
        if (!TextUtils.isEmpty(json)) {
            Log.e("loge", "onResponse: " + json);
            if (!TextUtils.isEmpty(json)) {
                String data = json.replace(json.substring(2, 16), "data");
                NewsListEntity newsListEntity = gson.fromJson(data, NewsListEntity.class);
                if (newsListEntity.getData() != null) {

                    if (startPage==0){
                        dataBeen.clear();
                    }
                    dataBeen.addAll(newsListEntity.getData());
                    startPage = startPage + 10;
                    endPage = endPage + 10;
                } else {
                    startPage = startPage + 10;
                    endPage = endPage + 10;
                }
                dataBeen.add(new NewsListEntity.DataBean(2));
                newsRVAdapter.setData(dataBeen);

            }
        }
    }

    @Override
    public void onFailure(String url, String error) {

    }

    private void addLastItem() {
        if (startPage != 10) {
            dataBeen.add(new NewsListEntity.DataBean(3));

        }
    }

    private void removeLoadItem() {

        if (dataBeen.size() != 0) {
            if (dataBeen.get(dataBeen.size() - 1).getType() == 2) {
                dataBeen.remove(dataBeen.size() - 1);
            }
        }
    }

    @Override
    public void onCallback() {
        loadData();
    }

    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(getActivity(), NewsTVDetailActivity.class);
        intent.putExtra("data",dataBeen.get(position));
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        startPage = 0;
        endPage = 10;
        loadData();
    }

    private void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        if (srl != null && srl.isRefreshing()) {
            srl.setRefreshing(false);
        }
    }
}
