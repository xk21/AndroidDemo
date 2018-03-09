package com.jj.tt.mvpdemo.interfaces;

import com.jj.tt.mvpdemo.mode.data.Book;

/**
 * Created by chenmingying on 2018/3/8.
 */

public interface OnUserBookListener {
    void getUserBookSuccess(Book book);
    void getUserBookFailed(String book);
}
