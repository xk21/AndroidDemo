package com.jj.tt.androiddemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by admin on 2017/3/15.
 */
public abstract class MVPBaseActivity <V,T extends BasePresenter> extends Activity {
    private static final String TAG = "TAG";
    private T mPresenter;//presenter对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();//创建presenter
        mPresenter.attachView(this);//view与presenter建立关联
        Log.i(TAG, "attachView-mPresenter="+mPresenter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()-mPresenter="+mPresenter);
        mPresenter.detachView();
    }

    protected abstract  T createPresenter();
}
