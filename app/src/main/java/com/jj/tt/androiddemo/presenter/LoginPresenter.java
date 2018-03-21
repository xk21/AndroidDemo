package com.jj.tt.androiddemo.presenter;

import android.os.Handler;

import com.jj.tt.androiddemo.base.BasePresenter;
import com.jj.tt.androiddemo.biz.ILoginBiz;
import com.jj.tt.androiddemo.biz.ILoginLisener;
import com.jj.tt.androiddemo.biz.LoginBizImpl;
import com.jj.tt.androiddemo.view.ILoginView;


/**
 * Created by admin on 2017/3/15.
 */
public class LoginPresenter extends BasePresenter {
    ILoginBiz iLoginBiz;
    ILoginView iLoginView;
    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView=iLoginView;
        iLoginBiz=new LoginBizImpl();//需构造的是实现类
    }

    Handler mHandler = new Handler();
    public void login() {
        iLoginView.showProgress();
        //执行耗时操作
        iLoginBiz.login(iLoginView.getName(), iLoginView.getPassword(), new ILoginLisener() {
            @Override
            public void loginSuccess() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hideProgress();//然后toast提示成功
                        iLoginView.loginSuccess();
                    }
                });

            }

            @Override
            public void loginFaile() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hideProgress();//然后toast提示失败
                        iLoginView.loginFailer();
                    }
                });

            }
        });
    }
}
