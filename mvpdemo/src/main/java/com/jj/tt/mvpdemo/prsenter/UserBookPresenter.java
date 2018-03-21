package com.jj.tt.mvpdemo.prsenter;

import com.jj.tt.mvpdemo.base.BasePresenter;
import com.jj.tt.mvpdemo.interfaces.IUserBookShowListener;
import com.jj.tt.mvpdemo.interfaces.OnUserBookListener;
import com.jj.tt.mvpdemo.mode.UserBookMode;
import com.jj.tt.mvpdemo.mode.data.Book;

/**
 * Created by chenmingying on 2018/3/8.
 */

public class UserBookPresenter extends BasePresenter {

    private UserBookMode mUserBookMode;
    private IUserBookShowListener iUserBookShowListener;

    public UserBookPresenter(IUserBookShowListener iUserBookShowListener) {
        this.iUserBookShowListener = iUserBookShowListener;
        mUserBookMode = new UserBookMode();
    }

    public void getUserBook(final int i) {
        mUserBookMode.getUserBook(i, new OnUserBookListener() {
            @Override
            public void getUserBookSuccess(Book book) {
                if (iUserBookShowListener==null){
                    return;
                }
                iUserBookShowListener.getUserBookSuccess(book);
            }

            @Override
            public void getUserBookFailed(String book) {
                if (iUserBookShowListener==null){
                    return;
                }
                iUserBookShowListener.getUserBookFailed(book);
            }
        });
    }


    @Override
    public void onDestroy() {
        if (iUserBookShowListener!= null){
            iUserBookShowListener =null;
        }
        System.gc();
    }
}
