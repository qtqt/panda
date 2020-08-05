package com.panda.utils;

import android.widget.Toast;

import com.panda.Constants;


/**
 *@date 2018/1/17
 *@blog http://my.csdn.net/qtiao
 *@desc Toast统一管理类
 *
 */

public class T {
    private T() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 短时间显示Toast
     * @param msg
     */
    public static void showShort(final CharSequence msg) {
        if (Constants.isShow&&Constants.appContext!=null){
            Constants.mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Constants.appContext, msg, Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    /**
     * 短时间显示Toast
     * @param resId
     */
    public static void showShort(final int resId) {
        if (Constants.isShow&&Constants.appContext!=null){
            Constants.mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Constants.appContext, resId, Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    /**
     * 长时间显示Toast
     */
    public static void showLong(final CharSequence msg) {
        if (Constants.isShow&&Constants.appContext!=null){
            Constants.mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Constants.appContext, msg, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    /**
     * 自定义显示Toast时间
     * @param msg
     * @param duration
     */
    public static void show(final CharSequence msg,final int duration) {
        if (Constants.isShow&&Constants.appContext!=null){
            Constants.mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Constants.appContext, msg, duration).show();
                }
            });
        }
    }
}
