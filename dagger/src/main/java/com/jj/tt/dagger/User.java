package com.jj.tt.dagger;

import javax.inject.Inject;

/**
 * Created by chenmingying on 2018/3/20.
 */

public class User {
    private String name;

    @Inject
    public User(){
        this.name = "Sir1";
    }

    public String getName(){
        return name;
    }
}
