package com.example.a11355.myshowdou;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a11355.myshowdou.Base.BaseActivity;
import com.example.a11355.myshowdou.Base.BaseDialog;
import com.example.a11355.myshowdou.Knowledges.KnowledgesFragment;
import com.example.a11355.myshowdou.News.view.NewsFragment;
import com.example.a11355.myshowdou.Photos.PhotosFragment;
import com.example.a11355.myshowdou.Utils.BitMapUtil;
import com.example.a11355.myshowdou.Utils.Constant;
import com.example.a11355.myshowdou.Utils.OkHttpUtil;
import com.example.a11355.myshowdou.Utils.PreferencesUtil;
import com.example.a11355.myshowdou.Utils.ToastUtil;
import com.example.a11355.myshowdou.Utils.Util;
import com.example.a11355.myshowdou.Videos.VideosFragment;
import com.example.a11355.myshowdou.custom.DownloadDialog;
import com.example.a11355.myshowdou.custom.NewVersionDialog;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static android.R.attr.versionName;


/*
* 主Activity
*
* */
public class MainActivity extends BaseActivity<MainView, MainPresenterImpl>
        implements NavigationView.OnNavigationItemSelectedListener, RadioGroup.OnCheckedChangeListener, BaseDialog.OnItemClickListener, View.OnClickListener, OkHttpUtil.OnProgressListener, MainView {

    @BindView(R.id.rg)
    RadioGroup rg;
    private FragmentManager fragmentManager;
    private NewsFragment newsFragment;
    private int page = 0;
    private VideosFragment videosFragment;
    private PhotosFragment photosFragment;
    private KnowledgesFragment knowledgesFragment;
    private String versionNum;

    private boolean isExit = false;//退出标识
    private boolean isForce;//是否强制升级
    private Handler handler = new Handler();
    private String ver;
    private String downloadUrl;
    private String description;
    private NewVersionDialog newVersionDialog;
    private String filePath;
    private DownloadDialog downloadDialog;
    private Menu menu;
    private MenuItem item;
    private boolean isCheck;

    @Override
    protected int getViewResId() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void init() {
        Bmob.initialize(this, "a86f4153e71e9561f941ea31ad91384f");//初始化bomb
        versionNum = getVersionNum();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(0);
        }
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
        rg.getChildAt(page).performClick();
    }

    @Override
    public MainPresenterImpl initPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        item = menu.findItem(R.id.type);
        item.setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

    private void update(String versionNum) {
        isForce = false;
        String charAt0 = versionNum.charAt(0) + "";
        if ("V".equals(charAt0) || "v".equals(charAt0)) {
            ver = versionNum.substring(1, versionNum.length());
        }
        if ("V".equals(charAt0)) {
            isForce = true;
        }
        int needUpdate = Util.isNeedUpdate(Util.getAppVersion(this), ver);
        switch (needUpdate) {
            case 2://需要强制更新
                isForce = true;
            case 1://需要更新
                newVersionDialog = NewVersionDialog.newInstance("发现新版本 " + versionNum, description, isForce == true ? "force" : "取消", "更新");
                newVersionDialog.setOnItemClickListener(this);
                newVersionDialog.show(getFragmentManager());
                break;
            default:
                if (isCheck) {
                    ToastUtil.initToast(this, "已是最新版本，无需更新");
                }
                break;
        }


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (isExit) {
                System.exit(0);
            } else {
                ToastUtil.initToast(this, "再按一次退出" + Util.getAppName(this));
                isExit = true;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 3000);//5秒内再按后退键真正退出
            }
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
        if (id == R.id.rd) {//热点视频
            if (this.item != null) {
                if (videosFragment != null) {
                    this.item.setTitle("热点视频");
                    videosFragment.setUrlPosion(0);
                    videosFragment.onRefresh();
                }
            }
            return true;
        }
        if (id == R.id.yl) {//娱乐视频
            if (this.item != null) {
                if (videosFragment != null) {
                    this.item.setTitle("娱乐视频");
                    videosFragment.setUrlPosion(1);
                    videosFragment.onRefresh();
                }
            }
            return true;
        }
        if (id == R.id.gx) {//搞笑视频
            if (this.item != null) {
                if (videosFragment != null) {
                    this.item.setTitle("搞笑视频");
                    videosFragment.setUrlPosion(2);
                    videosFragment.onRefresh();
                }
            }
            return true;
        }
        if (id == R.id.jp) {//精品视频
            if (this.item != null) {
                if (videosFragment != null) {
                    this.item.setTitle("精品视频");
                    videosFragment.setUrlPosion(3);
                    videosFragment.onRefresh();

                }
            }
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
        } else if (id == R.id.nav_gallery) {//打电话
            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri data = Uri.parse("tel:" + "13632840502");
            intent.setData(data);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {//更新
           // ToastUtil.initToast(this, "已是最新版本，无需更新");
            isCheck = true;
            checkStoragePermission();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {//分享
            String filePath = Environment.getExternalStorageDirectory() + "/Android/data/" +
                    getPackageName() + "/cache/logo.jpg";
            if (!new File(filePath).exists()) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                BitMapUtil.saveBitmap2File(bitmap, filePath);
            }
            PreferencesUtil.showShare(this, "趣逗最新下载地址", "http://bmob-cdn-11489.b0.upaiyun.com/2017/05/14/78bb756f401c73d680c6b941165af335.apk", "欢迎大家下载", filePath, this);
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (item != null) {
            item.setVisible(false);

        }
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
                if (item != null) {
                    item.setVisible(true);

                }
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


    public String getVersionNum() {

        //查找Person表里面id为6b6c11c537的数据
        BmobQuery<VersionController> query = new BmobQuery<>();
        query.findObjects(new FindListener<VersionController>() {
            @Override
            public void done(List<VersionController> list, BmobException e) {
                if (e == null) {
                    versionNum = list.get(0).getVersionNum();
                    downloadUrl = list.get(0).getDownloadUrl();
                    description = list.get(0).getDescription();
                    checkStoragePermission();


                }

            }
        });
        return versionNum;
    }


    @Override
    public void onItemClick(View v) {
        if (newVersionDialog != null) {
            newVersionDialog.dismiss();

        }

        downloadDialog = DownloadDialog.newInstance(Util.getAppName(this) + versionNum, isForce);
        downloadDialog.show(getFragmentManager(), "download");
        filePath = Environment.getExternalStorageDirectory() + "/Download/" + Util.getAppName(this) +
                "_" + versionName + ".apk";
        Log.e("loge", "Download: " + filePath);
        OkHttpUtil.fileDownload(downloadUrl, filePath, this, new OkHttpUtil.OnDataListener() {
            @Override
            public void onResponse(String url, String json) {//下载完成
                TextView btnInstall = downloadDialog.getBtnInstall();
                btnInstall.setSelected(true);
                btnInstall.setText("安装");
                btnInstall.setClickable(true);
                btnInstall.setOnClickListener(MainActivity.this);
                jumpInstall();
            }

            @Override
            public void onFailure(String url, String error) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        jumpInstall();
    }

    /**
     * 跳转到安装页面
     */
    private void jumpInstall() {
        File apkFile = new File(filePath);
        if (apkFile.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            startActivity(intent);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    @Override
    public void onProgress(final int rate) {
        ProgressBar pb = downloadDialog.getProgressBar();
        final TextView btnInstall = downloadDialog.getBtnInstall();
        if (pb != null) {
            pb.setProgress(rate);
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (btnInstall != null) {
                    btnInstall.setText("下载中(" + rate + "%)");
                    if (rate == 100) {
                        btnInstall.setText("安装");
                    }
                }
            }
        });
    }

    private void checkStoragePermission() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    Constant.Code.PermissionCode);
        } else {
            update(versionNum);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Constant.Code.PermissionCode) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                ToastUtil.initToast(this, "存储权限被拒绝，使用过程中可能会出现未知错误");
            } else {
                update(versionNum);

            }
        }
    }

}
