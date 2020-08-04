package com.panda.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by win7 on 2018/10/29.
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    protected String TAG = getClass().getSimpleName();

    protected View mRootView;
    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    protected boolean hasFetchData; 	// 标识已经触发过懒加载数据
    protected T mViewBind;

    protected abstract int getLayoutId();
    protected abstract void initData();

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        TAG=getClass().getSimpleName();
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewBind = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        mRootView = mViewBind.getRoot();
        return mRootView;
    }

    private void lazyFetchDataPrepared() {
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            initData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyFetchDataPrepared();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewPrepared = true;
        lazyFetchDataPrepared();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hasFetchData = false;
        isViewPrepared = false;
    }

    /**
     * 根据ID返回页面控件类型
     *
     * @param id
     * @return
     */
    public <VT extends View> VT findViewById(int id) {
        VT view = mRootView.findViewById(id);
        if (view == null)
            throw new NullPointerException("This resource id is invalid.");
        return view;
    }

    /**
     * 返回
     * @return true-已处理 false-未处理
     */
    public boolean onBackPressed(){return false;}


    /**
     * 用于从Activity设置数据的Fragment
     * @param isRefresh 是否刷新数据
     * @param data 传送的数据
     */
    public void setData(boolean isRefresh,Bundle data){}

}
