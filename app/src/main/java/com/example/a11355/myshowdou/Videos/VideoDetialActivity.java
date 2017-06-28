package com.example.a11355.myshowdou.Videos;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.a11355.myshowdou.Base.BaseActivity;
import com.example.a11355.myshowdou.Base.BasePresenter;
import com.example.a11355.myshowdou.R;

public class VideoDetialActivity extends BaseActivity {


    private VideoListEntity.DataBean data;

    @Override
    protected int getViewResId() {
        return R.layout.activity_video_detial;
    }

    @Override
    protected void init() {

        data = getIntent().getParcelableExtra("data");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("视频");
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

}
