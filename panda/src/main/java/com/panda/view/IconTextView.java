package com.panda.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 *@date 2020/8/28
 *@blog http://my.csdn.net/qtiao
 *@desc 
 *
 */

public class IconTextView extends TextView {

    private Context mContext;

    public IconTextView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView(){
        Typeface iconfont = Typeface.createFromAsset(mContext.getAssets(), "iconfont/iconfont.ttf");
        setTypeface(iconfont);
    }
}
