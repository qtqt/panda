package com.panda;

import android.app.Application;

/**
 *@date 2020/8/5
 *@blog http://my.csdn.net/qtiao
 *@desc 
 *
 */

public abstract class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Constants.appContext = getApplicationContext();

    }
}
