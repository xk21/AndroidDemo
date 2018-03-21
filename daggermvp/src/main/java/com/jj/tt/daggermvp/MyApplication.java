package com.jj.tt.daggermvp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by chenmingying on 2018/3/21.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLeakCanary();
    }
    /**
     * 初始化内存检测工具
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
