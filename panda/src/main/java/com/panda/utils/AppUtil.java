package com.panda.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.panda.Constants;

import java.util.ArrayList;
import java.util.List;


/**
 *@date 2018/1/17
 *@blog http://my.csdn.net/qtiao
 *@desc App相关辅助类
 *
 */

public class AppUtil {

    /**
     * 获取应用程序名称
     */
    public static String getAppName()
    {
        try
        {
            PackageManager packageManager = Constants.appContext.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    Constants.appContext.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return Constants.appContext.getResources().getString(labelRes);
        } catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     * @return 当前应用的版本名称
     */
    public static String getVersionName()
    {
        try
        {
            PackageManager packageManager = Constants.appContext.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    Constants.appContext.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /*public static String getSN(){
        String sn="";
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class);
            sn = (String) get.invoke(c, "ro.boot.serialno");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sn;
    }*/

    public static boolean isInstall(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        List<String> pName = new ArrayList<String>();
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(packageName);
    }
}
