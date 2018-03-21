package com.jj.tt.daggermvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by chenmingying on 2018/3/12.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends AppCompatActivity {

    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter !=null){
            mPresenter.detachView();
            mPresenter = null;
            System.gc();
        }
    }

    public abstract P getPresenter();

}
