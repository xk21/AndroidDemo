package com.jj.tt.androiddemo.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by admin on 2017/3/15.
 */
public abstract class BasePresenter<T> {
    protected Reference<T> mViewRef;//view接口类型的弱引用
    public  void attachView(T view){
        mViewRef = new WeakReference<T>(view);//建立关联
    }
    protected T getView(){
        return  mViewRef.get();
    }
    public boolean isViewAttached(){
        return  mViewRef !=null && mViewRef.get() !=null;
    }
    public  void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
            mViewRef =null;
        }
    }
}



