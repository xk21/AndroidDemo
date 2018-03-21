package com.jj.tt.daggermvp.interfaces;


import com.jj.tt.daggermvp.mode.data.Book;

/**
 * Created by chenmingying on 2018/3/8.
 */

public interface OnUserBookListener {
    void getUserBookSuccess(Book book);
    void getUserBookFailed(String book);
}
