package com.example.a11355.myshowdou.Base;

public abstract class BasePresenter<T> {

     public T mView;    

     public void attach(T mView) {       
         this.mView = mView;    
     }    

     public void dettach() {        
         mView = null;    
     }
}