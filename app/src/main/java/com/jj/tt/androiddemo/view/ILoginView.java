package com.jj.tt.androiddemo.view;

/**
 * Created by admin on 2017/3/15.
 */
public interface ILoginView {
    void showProgress();
    void hideProgress();
    String getName();
    String getPassword();
    void loginSuccess();
    void loginFailer();
}
