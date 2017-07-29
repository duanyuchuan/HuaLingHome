package com.hualing.hualinghome.protocol;

import android.text.TextUtils;

import com.hualing.hualinghome.HttpUtils.NetworkUtil;
import com.hualing.hualinghome.utils.IOUtils;
import com.hualing.hualinghome.utils.UiUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**网络请求的基类
 * Created by Administrator on 2017/7/29.
 */

public abstract class BaseProtocol<T> {
    /**
     * 获取网络数据
     * @param url
     * @return
     */
    public T getNetWorkData(String url){
        String result=getCache();
        if(TextUtils.isEmpty(result)){
            //没有缓存从网络获取数据
            result=getDataFromNetWork(url);
        }
        //解析数据
        if(result != null){
            return parseJson(result);
        }
        return null;
    }

    /**
     *加载网络数据
     * @return
     */
    public String getDataFromNetWork(String url){
        // http://www.itcast.cn/home?index=100&name=zhangsan&age=20
        // 链接 = 主域名 + 接口字段 + 参数
        String jsonString = NetworkUtil.doGet(url);
        if(!TextUtils.isEmpty(jsonString)){
            //数据请求成功，写缓存
            setCache(jsonString);
            return jsonString;
        }else {
            return "";
        }
    }

    /**
     * 写缓存
     * @param jsonString
     */
    private void setCache(String jsonString) {
        //获取系统目录
        File cacheDir = UiUtils.getContext().getCacheDir();
        //创建缓存文件
        File cacheFile=new File(cacheDir,getKey());
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(cacheFile);
            //缓存事件半个小时，文件第一行写入截止时间
            long deadLine=System.currentTimeMillis()+30*60*1000;
            fileWriter.write(deadLine+"\n");//要加换行
            fileWriter.write(jsonString);
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtils.close(fileWriter);
        }
    }

    /**
     * 获取缓存数据
     * @return
     */
    private String getCache() {
        //获取系统缓存目录
        File cacheDir = UiUtils.getContext().getCacheDir();
        //创建缓存文件
        File cacheFile=new File(cacheDir,getKey());
        if(cacheFile.exists()){
            //有缓存
            BufferedReader reader=null;
            try{
                reader=new BufferedReader(new FileReader(cacheFile));
                String firstLine=reader.readLine();
                //获取截止时间
                Long deadLine=Long.parseLong(firstLine);
                if(System.currentTimeMillis()<deadLine){
                    //缓存有效
                    StringBuilder stringBuilder=new StringBuilder();
                    String line=null;
                    while((line=reader.readLine()) != null){
                        stringBuilder.append(line);
                    }
                    return stringBuilder.toString();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                IOUtils.close(reader);
            }
        }
        return null;
    }

    /**
     * 返回具体字段对应的参数必须由子类去实现
     * @return
     */
    //protected abstract String getParams();

    /**
     * 返回具体接口的字段必须由子类去实现
     * @return
     */
    protected abstract String getKey();

    /**
     * 解析Json数据必须由子类决定
     * @param result
     * @return
     */
    protected abstract T parseJson(String result);

}
