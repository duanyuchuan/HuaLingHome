package com.hualing.hualinghome.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.android.volley.RequestQueue;
import com.hualing.hualinghome.global.BaseApplication;


/**
 * 获取应用信息的工具类
 * @author Administrator
 *
 */
public class UiUtils {
	/***************获取BaseApplication的相关方法******************/
	
	/**
	 * 获取上下文的方法
	 * @return
	 */
	public static Context getContext(){
		return BaseApplication.getContext();
	}
	/**
	 * 获取Handler对象的方法
	 * @return
	 */
	public static Handler getHandler(){
		return BaseApplication.getHandler();
	}
	/**
	 * 获取Ui线程id的方法
	 * @return
	 */
	public static int getUiThread(){
		return BaseApplication.getUiThread();
	}
	/**
	 *获取Volley矿建的请求队列
	 * @return
	 */
	public static RequestQueue getRequestQueue(){
		return BaseApplication.getRequestQueue();
	}
	
	/***************获取资源文件的相关方法******************/
	
	/**
	 * 获取资源文件的字符串
	 * @param stringId
	 * @return
	 */
	public static String getResourcesString(int stringId){
		return getContext().getResources().getString(stringId);
	}
	/**
	 * 获取资源文件下的字符串数组
	 * @param stringArrayId
	 * @return
	 */
	public static String[] getResourcesStringArray(int stringArrayId){
		return getContext().getResources().getStringArray(stringArrayId);
	}
	/**
	 * 获取资源文件下的Drawable对象
	 * @param drawableId
	 * @return
	 */
	public static Drawable getResourcesDrawable(int drawableId){
		return getContext().getResources().getDrawable(drawableId);
	}
	/**
	 * 获取资源文件下的Color
	 * @param colorId
	 * @return
	 */
	public static int getResourcesColor(int colorId){
		return getContext().getResources().getColor(colorId);
	}
	/**
	 * 获取资源文件下的颜色状态选择器
	 * @param colorStateListId
	 * @return
	 */
	public static ColorStateList getResourcesColorStateList(int colorStateListId){
		return getContext().getResources().getColorStateList(colorStateListId);
	}
	/**
	 * 加载资源文件下的尺寸
	 * @param sizeId
	 * @return
	 */
	public static int getResourcesDimen(int sizeId){
		//获取对象的像素值
		return getContext().getResources().getDimensionPixelSize(sizeId);
	}
	
	/***************dp转px******************/	
	//dp=px/设备密度
	
	/**
	 * dp转换为px
	 * @param dp
	 * @return
	 */
	public static int dpTopx(int dp){
		float density = getContext().getResources().getDisplayMetrics().density;
		return (int) (dp*density+0.5f);
	}
	/**
	 * px转换为dp
	 * @param px
	 * @return
	 */
	public static float pxTodp(int px){
		float density = getContext().getResources().getDisplayMetrics().density;
		return px/density;
	}
	
	/***************通过布局文件加载布局对象******************/	

	/**
	 * 加载布局文件
	 * @param layoutId
	 * @return
	 */
	public static View inflate(int layoutId){
		return View.inflate(getContext(), layoutId, null);
	}
	
	/***************判断当前线程是否是主线程******************/	
	
	/**
	 * 判断当前线程是否是主线程
	 * @return
	 */
	public static boolean isRunUiThread(){
		return android.os.Process.myTid()==getUiThread();
	}
	/**
	 * 在主线程运行
	 * @param runnable
	 */
	public static void runOnUiThread(Runnable runnable){
		//判断是否运行在主线程
		if(isRunUiThread()){
			runnable.run();
		}else{
			//Handler不仅可以发送一个Message对象，还可以发送一个Runnable对象，也是运行在主线程的
			getHandler().post(runnable);
		}
	}
}
