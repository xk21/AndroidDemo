package com.jj.tt.daggermvp.presenter;


import android.content.Context;
import android.util.Log;

import com.jj.tt.daggermvp.Componet.DaggerUserBookPresenterComponet;
import com.jj.tt.daggermvp.base.BasePresenter;
import com.jj.tt.daggermvp.interfaces.IUserBookShowListener;
import com.jj.tt.daggermvp.interfaces.OnUserBookListener;
import com.jj.tt.daggermvp.mode.UserBookMode;
import com.jj.tt.daggermvp.mode.data.Book;

import javax.inject.Inject;

/**
 * Created by chenmingying on 2018/3/8.
 */

public class UserBookPresenter extends BasePresenter<IUserBookShowListener> {

    @Inject
    UserBookMode mUserBookMode;
    public UserBookPresenter( Context aaa) {
        DaggerUserBookPresenterComponet.create().inject(this);
        Log.d("szjjyh","getUserBookSucce11ss="+obtainView());

    }

    public void getUserBook(final int i) {
        mUserBookMode.getUserBook(i, new OnUserBookListener() {
            @Override
            public void getUserBookSuccess(Book book) {
                Log.d("szjjyh","getUserBookSuccess=");
                obtainView().getUserBookSuccess(book);
            }

            @Override
            public void getUserBookFailed(String book) {
                Log.d("szjjyh","getUserBookFailed=");
                obtainView().getUserBookFailed(book);
            }
        });
    }

}
