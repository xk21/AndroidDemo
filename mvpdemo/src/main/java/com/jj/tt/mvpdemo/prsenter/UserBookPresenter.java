package com.jj.tt.mvpdemo.prsenter;

import com.jj.tt.mvpdemo.interfaces.IGetUserBook;
import com.jj.tt.mvpdemo.interfaces.IUserBookShowListener;
import com.jj.tt.mvpdemo.interfaces.OnUserBookListener;
import com.jj.tt.mvpdemo.mode.UserBookMode;
import com.jj.tt.mvpdemo.mode.data.Book;
import com.jj.tt.mvpdemo.view.MainActivity;

/**
 * Created by chenmingying on 2018/3/8.
 */

public class UserBookPresenter extends BasePresenter{

    private UserBookMode mUserBookMode;
    private IUserBookShowListener iUserBookShowListener;

    public UserBookPresenter() {
        mUserBookMode = new UserBookMode();
    }

    public void getUserBook(final int i){
        this.iUserBookShowListener = (IUserBookShowListener) weakRefView;
        mUserBookMode.getUserBook(i, new OnUserBookListener() {
            @Override
            public void getUserBookSuccess(Book book) {
                iUserBookShowListener.getUserBookSuccess(book);
            }

            @Override
            public void getUserBookFailed(String book) {
                iUserBookShowListener.getUserBookFailed(book);
            }
        });
    }
}
