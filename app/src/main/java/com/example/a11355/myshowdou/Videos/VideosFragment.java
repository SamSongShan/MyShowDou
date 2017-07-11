package com.example.a11355.myshowdou.Videos;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
/*
* 视频
*
* */

/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, OkHttpUtil.OnDataListener, OnAdapterCallbackListener, AbsRecyclerAdapter.OnItemClickListener {


    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.rv_video)
    RecyclerView rvVideo;


    private int startPage = 0;
    private Gson gson = new GsonBuilder().create();

    private int urlPosion = 0;

    private List<VideoListEntity.DataBean> dataBeen = new ArrayList<>();
    private SpotsDialog loadingDialog;
    private String data;
    private VideoRVAdapter videoRVAdapter;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_videos;
    }

    @Override
    protected void init(View v) {
        rvVideo.setLayoutManager(new GridLayoutManager(getActivity(),2));
        videoRVAdapter = new VideoRVAdapter(getActivity(), this);
        rvVideo.setAdapter(videoRVAdapter);
        srl.setOnRefreshListener(this);
        videoRVAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void loadData() {
        if (startPage == 0) {
            loadingDialog = new SpotsDialog(getActivity(), "加载中...", R.style.Loading);
            loadingDialog.show();
        }


        OkHttpUtil.getJSON(String.format(Constant.URL.Videos, Constant.Strings.VideoDetailTitleUrl[urlPosion], startPage), this);
    }

    @Override
    public void onRefresh() {
        startPage = 0;
        loadData();
    }

    @Override
    public void onResponse(String url, String json) {
        dismissLoading();
        removeLoadItem();
        if (!TextUtils.isEmpty(json)) {
            Log.e("loge", "onResponse: " + json);
            if (!TextUtils.isEmpty(json)) {
            if (urlPosion == 3) {

                    data = json.replace(json.substring(2, 10), "data");

                } else {
                    data = json.replace(json.substring(2, 11), "data");

                }
                VideoListEntity videoListEntity = gson.fromJson(data, VideoListEntity.class);
                if (videoListEntity.getData() != null) {

                    if (startPage == 0) {
                        dataBeen.clear();
                    }
                    dataBeen.addAll(videoListEntity.getData());
                    startPage = startPage + 10;
                } else {
                    startPage = startPage + 10;
                }
                dataBeen.add(new VideoListEntity.DataBean(1));
                videoRVAdapter.setData(dataBeen);

            }
        }
    }

    @Override
    public void onFailure(String url, String error) {

    }

    private void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        if (srl != null && srl.isRefreshing()) {
            srl.setRefreshing(false);
        }
    }

    private void removeLoadItem() {

        if (dataBeen.size() != 0) {
            if (dataBeen.get(dataBeen.size() - 1).getType() == 1) {
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
        if (dataBeen.size()>position){
            Intent intent = new Intent(getActivity(), VideoDetialActivity.class);
            intent.putExtra("data",dataBeen.get(position));
            intent.putExtra("urlPosion",urlPosion);
            startActivity(intent);
        }



    }

    public void setUrlPosion(int urlPosion) {
        this.urlPosion = urlPosion;
    }
}
