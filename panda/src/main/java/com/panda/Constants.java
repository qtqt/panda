package com.panda;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by win7 on 2018/3/5.
 */

public class Constants {
    public static boolean isDebug = BuildConfig.DEBUG;      // 是否打印log
    public static boolean isShow = true;                        //Toast
    public static Context appContext ;                          //Toast
    public static Handler mainHandler=new Handler(Looper.getMainLooper());
    public static final String TAG ="AIVoice";                  //通用tag


    public static final String  FLAVOR_XIAOHA="s_t_semantic";//小哈

}
