package com.panda.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *@date 2020/5/20
 *@blog http://my.csdn.net/qtiao
 *@desc RecyclerView base适配器
 *
 */

public abstract class BaseAdapter<Bean,V extends ViewDataBinding> extends RecyclerView.Adapter<BaseAdapter.VH<V>>{
    protected List<Bean> mData = new ArrayList();




    protected abstract int getLayoutId(int viewType);

    protected abstract void onBindView(V view,Bean itemBean,int position);

    public void  addData(Bean bean){
        mData.add(bean);
    }

    public void  addAllData(Collection<? extends Bean> beans){
        if(beans == null || beans.size() < 1){
            return;
        }
        mData.addAll(beans);
    }

    public void  addDataRefresh(Bean bean){
        mData.add(bean);
        notifyDataSetChanged();
    }

    public void  addDataRefresh(int index,Bean bean){
        if(index < 0){
            index = 0;
        }else if(index > getItemCount()){
            index = getItemCount();
        }
        mData.add(index,bean);
        notifyDataSetChanged();
    }

    public void  clear(){
        mData.clear();
    }

    public void  addAllDataRefresh(Collection<? extends Bean> beans){
        mData.addAll(beans);
        notifyDataSetChanged();
    }

    public void removeItem(Bean bean){
        mData.remove(bean);
    }

    public void removeItemRefresh(Bean bean){
        mData.remove(bean);
        notifyDataSetChanged();
    }

    public void removeItem(int index){
        mData.remove(index);
    }

    public void removeItemRefresh(int index){
        if(getItemCount() == 0){
            return;
        }
        if(index < 0){
            index = 0;
        }else if(index > getItemCount()){
            index = getItemCount();
        }

        mData.remove(index);
        notifyDataSetChanged();
    }

    public void removeAll(Collection<Bean> c){
        mData.removeAll(c);
    }

    public void removeRefresh(Collection<Bean> c){
        mData.removeAll(c);
        notifyDataSetChanged();
    }



    @Override
    public VH<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType),null);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.VH<V> holder, int position) {
        onBindView(holder.mView,mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public static class VH<V extends ViewDataBinding> extends RecyclerView.ViewHolder{
        protected V mView;
        public VH(View itemView) {
            super(itemView);
            mView = DataBindingUtil.bind(itemView);
        }
    }


}


