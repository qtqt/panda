package com.panda.utils;

import android.util.TypedValue;

import com.panda.Constants;


/**
 *@date 2018/1/17
 *@blog http://my.csdn.net/qtiao
 *@desc 单位转换类
 *
 */

public class DensityUtil {
    /**
     * dp转px
     * @return
     */
    public static int dp2px( float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, Constants.appContext.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     * @return
     */
    public static int sp2px( float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, Constants.appContext.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     * @param pxVal
     * @return
     */
    public static float px2dp( float pxVal) {
        final float scale = Constants.appContext.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     * @param pxVal
     * @return
     */
    public static float px2sp( float pxVal) {
        return (pxVal / Constants.appContext.getResources().getDisplayMetrics().scaledDensity);
    }
}
