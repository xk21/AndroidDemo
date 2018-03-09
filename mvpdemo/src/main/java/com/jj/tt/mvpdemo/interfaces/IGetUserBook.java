package com.jj.tt.mvpdemo.interfaces;

import com.jj.tt.mvpdemo.mode.data.Book;

/**
 * Created by chenmingying on 2018/3/8.
 */

public interface IGetUserBook {

    void getUserBook(int i,OnUserBookListener onUserBookListener);
}
