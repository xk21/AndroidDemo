package com.jj.tt.daggermvp.Componet;

import com.jj.tt.daggermvp.MainActivity;
import com.jj.tt.daggermvp.module.UserBookModule;

import dagger.Component;

/**
 * Created by chenmingying on 2018/3/21.
 */

@Component(modules = {UserBookModule.class})
public interface UserBookComponet {

    void inject(MainActivity activity);
}
