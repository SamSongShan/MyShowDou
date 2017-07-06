package com.example.a11355.myshowdou.Knowledges;


import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.a11355.myshowdou.Base.AbsRecyclerAdapter;
import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.Base.OnAdapterCallbackListener;
import com.example.a11355.myshowdou.Photos.PhotoDetialActivity;
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
 * 技术
 */
public class KnowledgesFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, OkHttpUtil.OnDataListener, OnAdapterCallbackListener, AbsRecyclerAdapter.OnItemClickListener {


    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.rv_photo)
    RecyclerView rvPhoto;
    int page = 1;

    private Gson gson = new GsonBuilder().create();
    private List<KnowlegesEntity.ResultsBean> results = new ArrayList<>();
    private SpotsDialog loadingDialog;
    private KnowleagesAVAdapter photoRVAdapter;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_knowledges;
    }

    @Override
    protected void init(View v) {
        rvPhoto.setLayoutManager(new LinearLayoutManager(getActivity()));
        photoRVAdapter = new KnowleagesAVAdapter(getActivity(),this);
        rvPhoto.setAdapter(photoRVAdapter);
        photoRVAdapter.setOnItemClickListener(this);
        srl.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {
        page = 1;
        loadData();
    }

    @Override
    protected void loadData() {
        if (page == 1) {
            loadingDialog = new SpotsDialog(getActivity(), "加载中...", R.style.Loading);
            loadingDialog.show();
        }
        OkHttpUtil.getJSON(String.format(Constant.URL.Photo, page), this);
    }




    @Override
    public void onResponse(String url, String json) {
        Log.e("loge", "onResponse: " + json);
        dismissLoading();
        removeLoadItem();
        if (page == 1) {
            results.clear();
        }
        if (!TextUtils.isEmpty(json)) {
            KnowlegesEntity photoEntity = gson.fromJson(json, KnowlegesEntity.class);
            if (photoEntity.getResults() != null)
                results.addAll(photoEntity.getResults());
            results.add(new KnowlegesEntity.ResultsBean(1));
            ++page;

        } else {
            results.add(new KnowlegesEntity.ResultsBean(2));

        }
        photoRVAdapter.setData(results);
    }

    @Override
    public void onFailure(String url, String error) {

    }


    private void removeLoadItem() {

        if (results.size() != 0) {
            if (results.get(results.size() - 1).getMyType() == 1) {
                results.remove(results.size() - 1);
            }
        }
    }

    private void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        if (srl != null && srl.isRefreshing()) {
            srl.setRefreshing(false);
        }
    }


    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(getActivity(), PhotoDetialActivity.class);
        intent.putExtra("data",results.get(position));
        startActivity(intent);
    }

    @Override
    public void onCallback() {
        loadData();
    }
}
