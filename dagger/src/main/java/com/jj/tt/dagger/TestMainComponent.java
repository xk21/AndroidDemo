package com.jj.tt.dagger;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chenmingying on 2018/3/20.
 */

@Component(modules = {MainModule.class})
@Singleton
@Named

public interface TestMainComponent {
    void inject(MainActivity activity);
}
