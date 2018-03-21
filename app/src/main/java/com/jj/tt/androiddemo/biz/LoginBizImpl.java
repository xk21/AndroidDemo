package com.jj.tt.androiddemo.biz;

/**
 * Created by admin on 2017/3/15.
 */
public class LoginBizImpl implements ILoginBiz {

    @Override
    public void login(final String name, final String password, final ILoginLisener iLoginLisener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(name.equals("yxz") && password.equals("123")){
                    iLoginLisener.loginSuccess();
                }else{
                    iLoginLisener.loginFaile();
                }
            }
        }).start();

    }
}
