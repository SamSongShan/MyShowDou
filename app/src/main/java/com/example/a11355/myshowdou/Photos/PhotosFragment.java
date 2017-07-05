package com.example.a11355.myshowdou.Photos;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.a11355.myshowdou.Base.AbsRecyclerAdapter;
import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.Base.OnAdapterCallbackListener;
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
public class PhotosFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, OkHttpUtil.OnDataListener, OnAdapterCallbackListener, AbsRecyclerAdapter.OnItemClickListener {

    /*
    * 图片
    *
    * */
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.rv_photo)
    RecyclerView rvPhoto;
    int page = 1;

    private Gson gson = new GsonBuilder().create();
    private List<PhotoEntity.ResultsBean> results = new ArrayList<>();
    private SpotsDialog loadingDialog;
    private PhotoRVAdapter photoRVAdapter;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_photos;
    }

    @Override
    protected void init(View v) {
        rvPhoto.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        photoRVAdapter = new PhotoRVAdapter(getActivity(),this);
        rvPhoto.setAdapter(photoRVAdapter);
        photoRVAdapter.setOnItemClickListener(this);
        srl.setOnRefreshListener(this);
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
    public void onRefresh() {
        page = 1;
        loadData();
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
            PhotoEntity photoEntity = gson.fromJson(json, PhotoEntity.class);
            if (photoEntity.getResults() != null)
                results.addAll(photoEntity.getResults());
            results.add(new PhotoEntity.ResultsBean(1));
            ++page;

        } else {
            results.add(new PhotoEntity.ResultsBean(2));

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
    public void onCallback() {
        loadData();
    }

    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(getActivity(), PhotoDetialActivity.class);
        intent.putExtra("data",results.get(position));
        startActivity(intent);
    }
}
