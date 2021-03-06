package com.example.a11355.myshowdou.Videos;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.a11355.myshowdou.Base.AbsRecyclerAdapter;
import com.example.a11355.myshowdou.Base.BaseActivity;
import com.example.a11355.myshowdou.Base.BasePresenter;
import com.example.a11355.myshowdou.Base.OnAdapterCallbackListener;
import com.example.a11355.myshowdou.R;
import com.example.a11355.myshowdou.Utils.BitMapUtil;
import com.example.a11355.myshowdou.Utils.Constant;
import com.example.a11355.myshowdou.Utils.OkHttpUtil;
import com.example.a11355.myshowdou.Utils.PreferencesUtil;
import com.example.a11355.myshowdou.Utils.ToastUtil;
import com.example.a11355.myshowdou.Videos.videomodel.VideoPlayer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class VideoDetialActivity extends BaseActivity implements OkHttpUtil.OnDataListener, OnAdapterCallbackListener, AbsRecyclerAdapter.OnItemClickListener, MediaPlayer.OnCompletionListener {


    @BindView(R.id.Player)
    VideoPlayer Player;
    @BindView(R.id.rv_video)
    RecyclerView rvVideo;
    private VideoListEntity.DataBean data;
    private int startPage = 0;
    private List<VideoListEntity.DataBean> dataBeen = new ArrayList<>();
    private int urlPosion = 0;
    private Gson gson = new GsonBuilder().create();
    private VideoRVAdapter videoRVAdapter;
    private Toolbar toolbar;
    private int position;//当前播放ID
    private MediaPlayer mediaPlayer;
    private Timer mTimer;
    private long count=10L;

    @Override
    protected int getViewResId() {
        return R.layout.activity_video_detial;
    }

    @Override
    protected void init() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
         urlPosion = getIntent().getIntExtra("urlPosion", 0);
        data = getIntent().getParcelableExtra("data");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(data.getTitle());
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filePath = Environment.getExternalStorageDirectory() + "/Android/data/" +
                        getPackageName() + "/cache/logo.jpg";
                if (!new File(filePath).exists()) {
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                    BitMapUtil.saveBitmap2File(bitmap, filePath);
                }
                if (position==0){
                    PreferencesUtil.showShare(VideoDetialActivity.this,data.getTitle(),data.getMp4_url(),data.getDescription(),filePath,null);

                }else {
                    PreferencesUtil.showShare(VideoDetialActivity.this,dataBeen.get(position).getTitle(),dataBeen.get(position).getMp4_url(),dataBeen.get(position).getDescription(),filePath,null);

                }
            }
        });
        Player.playVideo(data.getMp4_url(), data.getTitle());
        setTimer();
        rvVideo.setLayoutManager(new GridLayoutManager(this, 2));
        videoRVAdapter = new VideoRVAdapter(this, this);
        rvVideo.setAdapter(videoRVAdapter);
        videoRVAdapter.setOnItemClickListener(this);


    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (Player.isFullScreen()) {
            Player.setProtrait();
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        //一定要记得销毁View
        if (Player != null) {
            Player.destroyVideo();
            Player = null;
        }
        super.onDestroy();
    }

    @Override
    protected void loadData() {
        OkHttpUtil.getJSON(String.format(Constant.URL.Videos, Constant.Strings.VideoDetailTitleUrl[urlPosion], startPage), this);
    }

    @Override
    public void onResponse(String url, String json) {
        removeLoadItem();
        if (!TextUtils.isEmpty(json)) {
            Log.e("loge", "onResponse: " + json);
            if (!TextUtils.isEmpty(json)) {
                String datajson;
                if (urlPosion == 3) {

                    datajson = json.replace(json.substring(2, 10), "data");

                } else {
                    datajson = json.replace(json.substring(2, 11), "data");

                }
                VideoListEntity videoListEntity = gson.fromJson(datajson, VideoListEntity.class);
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

         this.position = position;
        toolbar.setTitle(dataBeen.get(position).getTitle());

        Player.playVideo(dataBeen.get(position).getMp4_url(), dataBeen.get(position).getTitle());

    }

    @Override

    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        Log.i("--Main--", "onConfigurationChanged");

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            // 当前屏幕为横屏
            toolbar.setVisibility(View.GONE);

        } else {

            //当前屏幕为竖屏
            toolbar.setVisibility(View.VISIBLE);

        }

    }

    public void setTimer(){
        mTimer = new Timer();

        TimerTask mTimerTask = new TimerTask() {

            @Override
            public void run() {
                if (mediaPlayer==null){
                    mediaPlayer = Player.mediaPlayer;

                }

                if (mediaPlayer!=null){
                    mediaPlayer.setOnCompletionListener(VideoDetialActivity.this);
                    stopTimer();
               }


                /*isTimerRunning = true;

                if (isChanging == true)//当用户正在拖动进度进度条时不处理进度条的的进度

                    return;

                MusicBox.skbMusic.setProgress(mediaPlayer.getCurrentPosition());*/

            }

        };

//每隔10毫秒检测一下播放进度

        mTimer.schedule(mTimerTask, 0, count);
    }

    private void stopTimer(){
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }

        count = 0L;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if (position<dataBeen.size()-1){
            ToastUtil.initToast(this,"即将播出下一集");

                this.position=this.position+1;


            toolbar.setTitle(dataBeen.get(position).getTitle());

            Player.playVideo(dataBeen.get(position).getMp4_url(), dataBeen.get(position).getTitle());
        }else {
            ToastUtil.initToast(this,"请加载更多");

        }


    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}
