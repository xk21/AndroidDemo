package com.jj.tt.daggermvp.interfaces;


import com.jj.tt.daggermvp.mode.data.Book;

/**
 * Created by chenmingying on 2018/3/21.
 */

public interface IUserBookShowListener {
    void getUserBookSuccess(Book book);
    void getUserBookFailed(String book);
}
