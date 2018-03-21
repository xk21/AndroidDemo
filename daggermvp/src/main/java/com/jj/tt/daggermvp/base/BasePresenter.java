package com.jj.tt.daggermvp.base;

import java.lang.ref.WeakReference;

/**
 * Created by chenmingying on 2018/3/21.
 */

public abstract class BasePresenter<V> {

    private WeakReference<V> mWeakReference;

    public void attachView(V view){
        mWeakReference = new WeakReference<>(view);
    }


    public void detachView() {
        if(isAttach()) {
            mWeakReference.clear();
            mWeakReference = null;
        }
    }
    public V obtainView(){
        return isAttach()?mWeakReference.get():null;
    }

    protected boolean isAttach() {
        return mWeakReference != null &&
                mWeakReference.get() != null;
    }
}
