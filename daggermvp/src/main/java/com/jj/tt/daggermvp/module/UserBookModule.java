package com.jj.tt.daggermvp.module;

import android.content.Context;

import com.jj.tt.daggermvp.presenter.UserBookPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chenmingying on 2018/3/21.
 */

@Module
public class UserBookModule {

    Context mContext;

    public UserBookModule(Context context){
        this.mContext = context;
    }

    @Provides
    public UserBookPresenter provideUserBookPresenter(){
        return new UserBookPresenter(mContext);
    }
}
