package com.panda.utils;

import android.util.Log;

import com.panda.Constants;


/**
 *@date 2018/1/17
 *@blog http://my.csdn.net/qtiao
 *@desc Log的统一管理
 *
 */

public class L {

    private L()
    {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void i(String tag, String msg) {
        if (Constants.isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (Constants.isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        //if (Constants.isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (Constants.isDebug)
            Log.v(tag, msg);
    }
}
