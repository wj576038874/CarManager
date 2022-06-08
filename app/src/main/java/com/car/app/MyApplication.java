package com.car.app;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * author: wenjie
 * date: 2022-06-08 17:20
 * descption:
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        LitePal.initialize(this);
    }


    public static Context getContext() {
        return context;
    }
}
