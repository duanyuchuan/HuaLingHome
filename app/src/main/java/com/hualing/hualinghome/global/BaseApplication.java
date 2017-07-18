package com.hualing.hualinghome.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 自定义Application
 * @author Administrator
 *
 */
public class BaseApplication extends Application {
	private static Context mContext;
	private static Handler mHandler;
	private static int mUiThread;
	private static RequestQueue mRequestQueue;

	@Override
	public void onCreate() {		
		super.onCreate();
		mContext = getApplicationContext();
		mHandler = new Handler();
		mUiThread = android.os.Process.myTid();
		mRequestQueue= Volley.newRequestQueue(getApplicationContext());
	}
	/**
	 * 获取Volley框架的请求队列
	 * @return
	 */
	public static RequestQueue getRequestQueue(){
		if(mRequestQueue == null){
			mRequestQueue=Volley.newRequestQueue(getContext());
		}
		return mRequestQueue;
	}
	/**
	 * 获取上下文
	 * @return
	 */
	public static Context getContext() {
		return mContext;
	}
	/**
	 * 获取Handler对象
	 * @return
	 */
	public static Handler getHandler() {
		return mHandler;
	}
	/**
	 * 获取主线程id
	 * @return
	 */
	public static int getUiThread() {
		return mUiThread;
	}
	
}
