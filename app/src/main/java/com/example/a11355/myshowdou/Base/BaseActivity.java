package com.example.a11355.myshowdou.Base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 所有Activity的基类
 */
public abstract class BaseActivity <V,T extends BasePresenter<V>> extends AppCompatActivity {

    private Unbinder unbinder;
    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        getBundle(savedInstanceState);
        setContentView(getViewResId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//手机竖屏
        unbinder = ButterKnife.bind(this);
        init();
        loadData();
    }

    protected void getBundle(Bundle state){}

    protected abstract int getViewResId();

    protected void init(){}

    protected void loadData(){}

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
        presenter.dettach();

    }
    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V)this);
    }
    // 实例化presenter
    public abstract T initPresenter();
}
