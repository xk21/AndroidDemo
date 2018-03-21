package com.jj.tt.mvpdemo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by chenmingying on 2018/3/12.
 */

public abstract class BaseMVPActivity<V,P extends BasePresenter> extends AppCompatActivity {

    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter !=null){
            mPresenter.detach();
            mPresenter.onDestroy();
            mPresenter = null;
            System.gc();
        }
    }

    protected abstract P createPresenter();
}
