package com.panda.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by win7 on 2020/8/4.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    protected String TAG;
    protected T mViewBind;

    protected Context mContext;
    protected boolean mfullScreen = true; //是否全屏


    protected abstract int getLayoutId();
    protected abstract void initData();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mfullScreen){
            fullScreen();
        }
        TAG = getLocalClassName();
        this.mContext=this;
        mViewBind = DataBindingUtil.setContentView(this,getLayoutId());
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mfullScreen){
            fullScreen();
        }
    }

    /**
     * 窗口常亮
     */
    protected  void windowBright(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON|
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }




    /**
     * 全屏设置
     */
    protected  void fullScreen(){
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    /**
     * 设置数据
     * @param type 类型
     * @param data 数据
     */
    public void setData(int type,String data){

    }
}
