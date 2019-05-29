package com.jiyun.android_work_1.utils;

import android.app.Application;

public class MyApp extends Application {
    public static MyApp myApp;

    public static MyApp getMyApp() {
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
    }
}
