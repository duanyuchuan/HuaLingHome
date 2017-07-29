package com.hualing.hualinghome.HttpUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/29.
 */

public class HttpHelper {
    private static HttpHelper mHttpHelperInstance;

    /**
     * 单例设计，只创建一个对象
     * @return
     */
    public static HttpHelper getInstance(){
        if(mHttpHelperInstance==null){
            synchronized (HttpHelper.class){
                if(mHttpHelperInstance==null){
                    mHttpHelperInstance = new HttpHelper();
                }
            }
        }
        return mHttpHelperInstance;
    }

    /**
     * Get请求数据
     * @param url
     * @return
     */
    public static HttpResult getString(String url){
        HttpGet httpGet=new HttpGet(url);
        return execute(url,httpGet);
    }
    /** post请求，获取返回字符串内容 */
    public static HttpResult post(String url, byte[] bytes) {
        HttpPost httpPost = new HttpPost(url);
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bytes);
        httpPost.setEntity(byteArrayEntity);
        return execute(url, httpPost);
    }

    /** 下载 */
    public static HttpResult download(String url) {
        HttpGet httpGet = new HttpGet(url);
        return execute(url, httpGet);
    }

    /**
     * 执行网络访问
     * @param url
     * @return
     */
    private static HttpResult execute(String url, HttpRequestBase httpRequestBase) {
        //判断是否需要采用Https
        boolean isHttps=url.startsWith("https://");
        AbstractHttpClient abstractHttpClient = HttpClientFactory.create(isHttps);
        HttpContext httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        HttpRequestRetryHandler retryHandler = abstractHttpClient.getHttpRequestRetryHandler();//获取重试机制
        int retryCount = 0;
        boolean retry = true;
        while (retry) {
            try {
                HttpResponse response = abstractHttpClient.execute(httpRequestBase, httpContext);//访问网络
                if (response != null) {
                    return new HttpResult(response, abstractHttpClient, httpRequestBase);
                }
            } catch (Exception e) {
                IOException ioException = new IOException(e.getMessage());
                retry = retryHandler.retryRequest(ioException, ++retryCount, httpContext);//把错误异常交给重试机制，以判断是否需要采取从事
                e.printStackTrace();
            }
        }
        return null;
    }
}
