package com.hualing.hualinghome.controller;

import com.hualing.hualinghome.listener.INetWorkDataChangeListener;
import com.hualing.hualinghome.utils.ThreadManager;

/**
 * Created by Administrator on 2017/7/29.
 */

public abstract class BaseController {
    protected INetWorkDataChangeListener mINetWorkDataChangeListener;

    /**
     * 发送异步请求
     * @param action
     * @param values
     */
    public void sendAsyncRequest(final int action,final Object... values){
        ThreadManager.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                handleAsyncRequest(action,values);
            }
        });
    }

    /**
     * 不开辟子线程，发送异步请求
     * @param action
     * @param values
     */
    public void sendAsyncRequestData(final int action,final Object... values){
        handleAsyncRequest(action,values);
    }
    /**
     * 处理异步请求必须由子类具体实现
     * @param action
     * @param values
     */
    protected abstract void handleAsyncRequest(int action, Object[] values);

    /**
     * 设置监听
     * @param listener
     */
    public void setINetWorkDataChangeListener(INetWorkDataChangeListener listener) {
        this.mINetWorkDataChangeListener=listener;
    }
}
