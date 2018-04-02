package com.jj.tt.daggermvp.mode;


import com.jj.tt.daggermvp.interfaces.IGetUserBook;
import com.jj.tt.daggermvp.interfaces.OnUserBookListener;
import com.jj.tt.daggermvp.mode.data.Book;

import javax.inject.Inject;

/**
 * Created by chenmingying on 2018/3/8.
 */

public class UserBookMode implements IGetUserBook {

    @Inject
    public UserBookMode(){

    }
    @Override
    public void getUserBook(final int i, final OnUserBookListener onUserBookListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Boolean aBoolean = false;
                for (int j = 1; j <= 5; j++) {
                    if (i == j) {
                        aBoolean = true;
                    }
                }
                if (aBoolean) {
                    onUserBookListener.getUserBookSuccess(new Book("西游记:" + i));
                } else {
                    onUserBookListener.getUserBookFailed("请求失败没有该书");
                }
            }
        }).start();
    }

}
