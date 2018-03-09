package com.jj.tt.mvpdemo.mode;

import android.content.Context;
import android.content.res.Resources;
import android.icu.util.IslamicCalendar;

import com.jj.tt.mvpdemo.interfaces.IGetUserBook;
import com.jj.tt.mvpdemo.interfaces.OnUserBookListener;
import com.jj.tt.mvpdemo.mode.data.Book;
import com.jj.tt.mvpdemo.prsenter.UserBookPresenter;

/**
 * Created by chenmingying on 2018/3/8.
 */

public class UserBookMode implements IGetUserBook {

    @Override
    public void getUserBook(final int i, final OnUserBookListener onUserBookListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30000);
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
