package com.jj.tt.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chenmingying on 2018/3/20.
 */
@Module
public class TestModule {

    @Provides
    Book provideBook(){
        return  new Book("book1");

    }
}
