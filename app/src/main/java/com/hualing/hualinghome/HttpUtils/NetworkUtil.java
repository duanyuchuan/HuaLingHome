package com.hualing.hualinghome.HttpUtils;

import com.hualing.hualinghome.utils.IOUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public class NetworkUtil {
	/**
	 * Get方式请求网络数据
	 * @param urlPath
	 * @return
	 */
	public static String doGet(String urlPath){
		String result="";
		InputStream inputStream=null;
		BufferedReader bufferedReader=null;
		try {
			URL url=new URL(urlPath);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if (conn.getResponseCode()==200) {
				inputStream = conn.getInputStream();
				bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
				StringBuilder stringBuilder=new StringBuilder();
				String line=null;
				while ((line=bufferedReader.readLine()) != null){
					stringBuilder.append(line);
				}
				result=stringBuilder.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtils.close(bufferedReader);
			IOUtils.close(inputStream);
		}
		return result;
	}

	/**
	 * Post方式请求网络数据
	 * @param urlPath
	 * @param params
	 * @return
	 */
	public static String doPost(String urlPath,HashMap<String, String> params){
		String result="";
		InputStream inputStream=null;
		BufferedReader bufferedReader=null;
		try {
			URL url=new URL(urlPath);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
//			--------------------------------------------
			String paramStr="";
			StringBuilder stringBuilder=new StringBuilder();
			Set<HashMap.Entry<String, String>> entrySet = params.entrySet();
			for (HashMap.Entry<String, String> entry : entrySet) {
				stringBuilder.append("&");
				stringBuilder.append(entry.getKey());
				stringBuilder.append("=");
				stringBuilder.append(entry.getValue());
			}
//			name=xxx&pwd=dsaad
			paramStr = stringBuilder.toString();
			paramStr=paramStr.substring(1);
//			--------------------------------------------
			conn.setDoOutput(true);
			conn.getOutputStream().write(paramStr.getBytes());
			if (conn.getResponseCode()==200) {
				inputStream = conn.getInputStream();
				bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
				StringBuilder builder=new StringBuilder();
				String line=null;
				while((line=bufferedReader.readLine()) != null){
					builder.append(line);
				}
				result=builder.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtils.close(bufferedReader);
			IOUtils.close(inputStream);
		}
		return result;
	}
	
}
