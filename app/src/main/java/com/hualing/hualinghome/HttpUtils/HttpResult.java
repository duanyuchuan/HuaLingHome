package com.hualing.hualinghome.HttpUtils;

import android.text.TextUtils;
import com.hualing.hualinghome.utils.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**请求结果对象
 * Created by Administrator on 2017/7/29.
 */

public class HttpResult {
    private HttpResponse mHttpResponse;
    private InputStream mInputStream;
    private String mString;
    private HttpClient mHttpClient;
    private HttpRequestBase mHttpRequestBase;

    public HttpResult(HttpResponse httpResponse,HttpClient httpClient,HttpRequestBase httpRequestBase){
        this.mHttpResponse=httpResponse;
        this.mHttpClient=httpClient;
        this.mHttpRequestBase=httpRequestBase;
    }

    /**
     * 获取状态码
     * @return
     */
    public int getCode(){
        StatusLine statusLine = mHttpResponse.getStatusLine();
        return statusLine.getStatusCode();
    }

    /**
     * 从结果中获取字符串，一旦获取会自动关闭流，且保存字符串，方便下次获取
     * @return
     */
    public String getString(){
        if(!TextUtils.isEmpty(mString)){
            return mString;
        }
        InputStream inputStream=getInputStream();
        ByteArrayOutputStream baos=null;
        if(inputStream != null){
            try {
                baos=new ByteArrayOutputStream();
                byte[] buffer=new byte[1024*4];
                int len=-1;
                while((len=inputStream.read(buffer)) != -1){
                    baos.write(buffer,0,len);
                }
                byte[] data=baos.toByteArray();
                mString=new String(data,"utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                IOUtils.close(baos);
                close();
            }
        }
        return mString;
    }

    /**
     * 获取流，需要使用完毕后调用close方法关闭网咯连接
     * @return
     */
    private InputStream getInputStream() {
        if(mInputStream==null && getCode()<300){
            HttpEntity entity = mHttpResponse.getEntity();
            try {
                mInputStream = entity.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mInputStream;
    }
    /** 关闭网络连接 */
    public void close(){
        if (mHttpRequestBase != null) {
            mHttpRequestBase.abort();
        }
        IOUtils.close(mInputStream);
        if (mHttpClient != null) {
            mHttpClient.getConnectionManager().closeExpiredConnections();
        }
    }
}
