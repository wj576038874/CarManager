package com.car.app;

import android.app.Application;

import org.litepal.LitePal;

/**
 * author: wenjie
 * date: 2022-06-08 17:20
 * descption:
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
