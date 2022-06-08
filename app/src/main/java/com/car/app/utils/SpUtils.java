package com.car.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.car.app.MyApplication;

public class SpUtils {

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;
    private volatile static SpUtils spUtils;

    private SpUtils() {
        sharedPreferences = MyApplication.getContext().getSharedPreferences("user", 0);
        editor = sharedPreferences.edit();
    }

    public boolean isLogin() {
        return sharedPreferences.getString("login_user", null) != null;
    }

    public void loginSuccess(String userName) {
        editor.putString("login_user", userName);
        editor.apply();
    }

    public void logout() {
        editor.remove("login_user");
        editor.apply();
    }

    public String getLoginUser() {
        return sharedPreferences.getString("login_user", null);
    }

    public static SpUtils getInstance() {
        if (spUtils == null) {
            synchronized (SpUtils.class) {
                if (spUtils == null) {
                    spUtils = new SpUtils();
                }
            }
        }
        return spUtils;
    }

}
