package com.hualing.hualinghome.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**线程管理工具类
 * Created by Administrator on 2017/7/19.
 */

public class ThreadManager {
    private static ThreadPool mThreadPool;
    /**
     * 获取一个线程池
     * @return
     */
    public static ThreadPool getThreadPool(){
        if(mThreadPool == null){
            synchronized (ThreadManager.class){
                if(mThreadPool == null){
                    int cpuNum = Runtime.getRuntime().availableProcessors();
                    int threadNum=cpuNum*2+2;
                    mThreadPool=new ThreadPool(threadNum,threadNum+2,0L);
                }
            }
        }
        return mThreadPool;
    }

    public static class ThreadPool{
        private ThreadPoolExecutor mThreadPoolExecutor;
        private int mCoreThreadNum;
        private int mMaxThreadNum;
        private long mKeepAliveTime;

        private ThreadPool(int coreThreadNum,int maxThreadNum,long keepAliveTime){
            this.mCoreThreadNum=coreThreadNum;
            this.mMaxThreadNum=maxThreadNum;
            this.mKeepAliveTime=keepAliveTime;
        }
        /**
         * 线程池执行线程的方法
         * @param runnable
         */
        public void execute(Runnable runnable){
            if(runnable == null){
                return;
            }
            if(mThreadPoolExecutor == null){
                mThreadPoolExecutor=new ThreadPoolExecutor(
                        mCoreThreadNum,
                        mMaxThreadNum,
                        mKeepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<Runnable>(),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy()
                        );
            }
            mThreadPoolExecutor.execute(runnable);
        }
    }
}
