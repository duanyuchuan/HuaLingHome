package com.hualing.hualinghome.holder;

import android.view.View;

/**HolderView的基类，相对于对getView方法的封装
 * Created by Administrator on 2017/7/27.
 */

public abstract class BaseHolderView<T> {
    private View mRootView;
    private T mData;//item项对应的数据

    public BaseHolderView(){
        //item的布局对象
        mRootView=initView();
        //给HolderView设置Tag
        mRootView.setTag(this);
    }
    /**
     * 初始化Item项的布局,具体的初始化必须由子类来实现
     * @return
     */
    protected abstract View initView();
    /**
     * 返回布局列表项
     * @return
     */
    public View getRootView(){
        return mRootView;
    }
    /**
     * 外部设置数据
     * @param data
     */
    public void setData(T data){
        this.mData=data;
        //根据设置的数据刷新界面
        refreshView(data);
    }
    /**
     * 外界获取数据
     * @return
     */
    public T getData(){
        return mData;
    }
    /**
     * 刷新具体界面的方法必须由子类来实现
     * @param data
     */
    protected abstract void refreshView(T data);
}
