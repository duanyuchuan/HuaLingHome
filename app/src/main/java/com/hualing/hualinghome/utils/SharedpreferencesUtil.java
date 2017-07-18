package com.hualing.hualinghome.utils;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 对Sharedpreferences功能的封装
 * @author Administrator
 *
 */
public class SharedpreferencesUtil {
	/**
	 * 保存布尔数据到sharedpreferences
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putBoolean(Context context,String key,boolean value){
		SharedPreferences sp=context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE); 
		sp.edit().putBoolean(key, value).commit();
	}
	/**
	 * 从sharedpreferences中获取布尔数据
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static boolean getBoolean(Context context,String key,boolean defValue){
		SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE);
		return sharedPreferences.getBoolean(key, defValue);
	}
	/**
	 * 保存String类型的数据到sharedpreferences
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putString(Context context,String key,String value){
		SharedPreferences sp=context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE); 
		sp.edit().putString(key, value).commit();
	}
	/**
	 * 从sharedpreferences中获取String类型的数据
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String getString(Context context,String key,String defValue){
		SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE);
		return sharedPreferences.getString(key, defValue);
	}
	/**
	 * 保存int类型的数据到sharedpreferences
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putInt(Context context,String key,int value){
		SharedPreferences sp=context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE); 
		sp.edit().putInt(key, value).commit();
	}
	/**
	 * 从sharedpreferences中获取int类型的数据
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static int getInt(Context context,String key,int defValue){
		SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE);
		return sharedPreferences.getInt(key, defValue);
	}
	/**
	 * 保存long类型的数据到sharedpreferences
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putLong(Context context,String key,long value){
		SharedPreferences sp=context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE); 
		sp.edit().putLong(key, value).commit();
	}
	/**
	 * 从sharedpreferences中获取long类型的数据
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static long getLong(Context context,String key,long defValue){
		SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE);
		return sharedPreferences.getLong(key, defValue);
	}
	/**
	 * 清除指定key的缓存数据
	 * @param contxt
	 * @param key
	 */
	public static void removeKey(Context contxt,String key){
		SharedPreferences sharedPreferences = contxt.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE);
		Editor edit = sharedPreferences.edit();
		edit.remove(key);
		edit.commit();
	}
	/**
	 * 清空缓存数据
	 * @param context
	 */
	public static void clearAll(Context context){
		SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstaints.SPFILENAME, Context.MODE_PRIVATE);
		Editor edit = sharedPreferences.edit();
		edit.clear();
		edit.commit();
	}
}
