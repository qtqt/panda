package com.panda.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.panda.R;


/**
 * Created by win7 on 2019/8/20.
 */

public abstract class BaseDialog extends Dialog {

    protected abstract int getLayoutId();
    protected abstract void initData();


    public BaseDialog(@NonNull Context context) {
        this(context, R.style.CommonDialog);
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData();
    }
}
