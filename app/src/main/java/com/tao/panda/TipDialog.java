package com.tao.panda;

import android.content.Context;

import com.panda.ui.BaseDialog;

/**
 * Created by win7 on 2020/11/17.
 */

public class TipDialog extends BaseDialog {

    public TipDialog(Context context){
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_tip;
    }

    @Override
    protected void initData() {

    }
}
