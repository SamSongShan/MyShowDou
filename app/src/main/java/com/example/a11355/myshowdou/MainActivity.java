package com.example.a11355.myshowdou;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.example.a11355.myshowdou.Base.BaseActivity;
import com.example.a11355.myshowdou.Knowledges.KnowledgesFragment;
import com.example.a11355.myshowdou.News.NewsFragment;
import com.example.a11355.myshowdou.Photos.PhotosFragment;
import com.example.a11355.myshowdou.Videos.VideosFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 主Activity
*
* */
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg)
    RadioGroup rg;
    private FragmentManager fragmentManager;
    private NewsFragment newsFragment;
    private int page = 0;
    private VideosFragment videosFragment;
    private PhotosFragment photosFragment;
    private KnowledgesFragment knowledgesFragment;

    @Override
    protected int getViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        rg.setOnCheckedChangeListener(this);
        rg.getChildAt(page).performClick();    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (checkedId) {
            case R.id.rb_news://新闻
                page = 0;
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.fl, newsFragment, "0");
                } else {
                    transaction.show(newsFragment);
                    //newsFragment.onRefresh();//隐藏后刷新
                }
                break;
            case R.id.rb_video://视频
                page = 1;

                if (videosFragment == null) {
                    videosFragment = new VideosFragment();
                    transaction.add(R.id.fl, videosFragment, "1");
                } else {
                    transaction.show(videosFragment);
                    //videosFragment.onRefresh();//隐藏后刷新

                }

                break;
            case R.id.rb_photo://photo
                page = 2;
                if (photosFragment == null) {
                    photosFragment = new PhotosFragment();
                    transaction.add(R.id.fl, photosFragment, "2");
                } else {
                    transaction.show(photosFragment);
                    //photosFragment.onRefresh();//隐藏后刷新

                }
                break;

            case R.id.rb_girl://技术
                page = 3;

                if (knowledgesFragment == null) {
                    knowledgesFragment = new KnowledgesFragment();
                    transaction.add(R.id.fl, knowledgesFragment, "3");
                } else {
                    transaction.show(knowledgesFragment);
                    //knowledgesFragment.onRefresh();//隐藏后刷新
                }

                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 先隐藏所有Fragment
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (videosFragment != null) {
            transaction.hide(videosFragment);
        }
        if (photosFragment != null) {
            transaction.hide(photosFragment);
        }
        if (knowledgesFragment != null) {
            transaction.hide(knowledgesFragment);
        }
    }
}
