package com.panda.ui;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.panda.R;


/**
 * Created by win7 on 2019/8/20.
 */

public abstract class BaseDialog<T extends ViewDataBinding> extends Dialog {

    protected T mViewBind;

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
        View v = getLayoutInflater().inflate(getLayoutId(),null);
        setContentView(v);
        mViewBind = DataBindingUtil.bind(v);
        initData();
    }
}
