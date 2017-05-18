package com.example.a11355.myshowdou.Base;

/**
 * Created by 11355 on 2017/5/18.
 */

public interface BasePresenter<T> {
    void attachView(T v);
    void unAttachView(T v);
}
