package com.example.a11355.myshowdou.News.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.a11355.myshowdou.Base.BaseActivity;
import com.example.a11355.myshowdou.Base.BasePresenter;
import com.example.a11355.myshowdou.News.bean.NewsListEntity;
import com.example.a11355.myshowdou.R;
import com.example.a11355.myshowdou.Utils.Constant;
import com.example.a11355.myshowdou.Utils.OkHttpUtil;

import dmax.dialog.SpotsDialog;

public class NewsTVDetailActivity extends BaseActivity implements OkHttpUtil.OnDataListener {
//新闻详情页
    private SpotsDialog loadingDialog;
    private NewsListEntity.DataBean data;

    @Override
    protected int getViewResId() {
        return R.layout.activity_news_tvdetail;
    }

    @Override
    protected void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intent = getIntent();
        data = intent.getParcelableExtra("data");

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });    }

    @Override
    protected void loadData() {
        loadingDialog = new SpotsDialog(this, "加载中...", R.style.Loading);
        loadingDialog.show();
        OkHttpUtil.getJSON(String.format(Constant.URL.NEW_DETAIL, data.getDocid().substring(0,16)), this);
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    private void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }

    }

    @Override
    public void onResponse(String url, String json) {
        dismissLoading();
        if (!TextUtils.isEmpty(json)){
            String jsonString = json.replaceAll(this.data.getDocid().substring(0,16), "data");
            Log.e("loge", "onResponse: "+ jsonString);

        }
    }

    @Override
    public void onFailure(String url, String error) {

    }
}
