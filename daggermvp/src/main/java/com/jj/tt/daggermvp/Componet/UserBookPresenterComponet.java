package com.jj.tt.daggermvp.Componet;

import com.jj.tt.daggermvp.presenter.UserBookPresenter;

import dagger.Component;

/**
 * Created by chenmingying on 2018/3/21.
 */

@Component
public interface UserBookPresenterComponet {
    void inject(UserBookPresenter userBookPresenter);
}
