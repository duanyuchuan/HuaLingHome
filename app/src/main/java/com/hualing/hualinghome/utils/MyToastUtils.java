package com.hualing.hualinghome.utils;

import android.widget.Toast;

/**
 * 自定义吐司工具类
 * @author Administrator
 *
 */
public class MyToastUtils {
	/**
	 * 自定义吐司
	 * @param msg
	 */
	public static void Toast(String msg){
		Toast.makeText(UiUtils.getContext(), msg, Toast.LENGTH_SHORT).show();
	}
}
