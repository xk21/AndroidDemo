package com.jj.tt.androiddemo.biz;

/**
 * Created by admin on 2017/3/15.
 */
public interface ILoginBiz {
    void login(String name, String password, ILoginLisener iLoginLisener);
}
