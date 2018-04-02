package com.jj.tt.dagger;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chenmingying on 2018/3/20.
 */

@Component(modules = {TestModule.class})
public interface TestComponent {
    void inject(MainActivity activity);
}
