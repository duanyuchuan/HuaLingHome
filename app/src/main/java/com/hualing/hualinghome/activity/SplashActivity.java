package com.hualing.hualinghome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.hualing.hualinghome.HomeActivity;
import com.hualing.hualinghome.HttpUtils.BitmapCache;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseActivity;
import com.hualing.hualinghome.bean.ActionParams;
import com.hualing.hualinghome.bean.Advertisement;
import com.hualing.hualinghome.bean.AdvertisementDetail;
import com.hualing.hualinghome.myinterface.OnSkipButtonViewListener;
import com.hualing.hualinghome.utils.MyConstaints;
import com.hualing.hualinghome.utils.SharedpreferencesUtil;
import com.hualing.hualinghome.utils.StartActivity;
import com.hualing.hualinghome.utils.UiUtils;
import com.hualing.hualinghome.view.SkipButtonView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import static com.hualing.hualinghome.utils.SharedpreferencesUtil.getInt;


/**导航页面
 * Created by Administrator on 2017/7/10.
 */

public class SplashActivity extends BaseActivity{
    private ImageView mIvAdertisement;
    private SkipButtonView mSkipButtonView;
    private int lastIdex=0;

    //跳过控件
    private int timeLength=3*1000;
    private int space=100;
    private int now=0;
    private int total;
    private MyHandler mMyHandler;
    private boolean mIsFrist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //初始化视图界面
        initView();
        //初始化数据
        initData();
    }
    /**
     * 刷新跳过按钮的进度
     */
    Runnable reshSkipButtonRunnable=new Runnable() {
        @Override
        public void run() {
            Message message = mMyHandler.obtainMessage(0);
            message.arg1=now;
            mMyHandler.sendMessage(message);
            mMyHandler.postDelayed(this,space);
            now++;
        }
    };
    /**
     * 初始化数据
     * 判斷是否需要從網絡獲取數據
     */
    private void initData() {
        getAdvertisementByNetData();
    }

    /**
     * 获取网络数据
     */
    private void getAdvertisementByNetData() {
        RequestQueue requestQueue=UiUtils.getRequestQueue();
        StringRequest stringRequest=new StringRequest(
                Request.Method.GET,
                MyConstaints.SPLASH_ADVERTISING_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(!TextUtils.isEmpty(response)){
                            int indext= getInt(UiUtils.getContext(),MyConstaints.LAST_IMAGE_INDEX,0);

                            Gson gson=new Gson();
                            Advertisement advertisement = gson.fromJson(response, Advertisement.class);
                            if(advertisement != null){
                                ArrayList<AdvertisementDetail> advertisementAds = advertisement.getAds();
                                if(advertisementAds!=null && advertisementAds.size()>0){
                                    int size=advertisementAds.size();
                                    AdvertisementDetail advertisementDetail = advertisementAds.get(indext%size);
                                    if(advertisementDetail != null){
                                        ArrayList<String> res_url = advertisementDetail.getRes_url();
                                        if(res_url.size()>0){
                                            String imageAdvertUrl = res_url.get(0);
                                            if(!TextUtils.isEmpty(imageAdvertUrl)){

                                                //加载网络图片
                                                getAdertImage(imageAdvertUrl);
                                                indext++;
                                                SharedpreferencesUtil.putInt(UiUtils.getContext(),MyConstaints.LAST_IMAGE_INDEX,indext);

                                                mMyHandler.post(reshSkipButtonRunnable);
                                            }
                                        }
                                        //跳转到WebView界面
                                        ActionParams action_params = advertisementDetail.getAction_params();
                                        if(action_params != null){
                                            mIvAdertisement.setTag(action_params);
                                            //为图片添加点击事件
                                            mIvAdertisement.setOnClickListener(new View.OnClickListener(){
                                                @Override
                                                public void onClick(View view) {
                                                    ActionParams action_params = (ActionParams) view.getTag();
                                                    Intent intent=new Intent(UiUtils.getContext(),WebViewActivity.class);
                                                    intent.putExtra(WebViewActivity.WEBVIEW_ACTIVITY,action_params);
                                                    startActivity(intent);
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        mSkipButtonView.setVisibility(View.GONE);
                        Message message = mMyHandler.obtainMessage(1);
                        //mMyHandler.sendMessage(message);
                        mMyHandler.sendMessageDelayed(message,3000);
                    }
                }
        );
        requestQueue.add(stringRequest);
    }

    /**
     * 加载网络图片
     */
    private void getAdertImage(final String imageUrl ) {
        ImageLoader imageLoader=new ImageLoader(UiUtils.getRequestQueue(),new BitmapCache());
        ImageLoader.ImageListener listener=imageLoader.getImageListener(mIvAdertisement,R.mipmap.xinggan4,R.mipmap.xinggan3);
        imageLoader.get(imageUrl, listener);
        imageLoader.isCached(imageUrl,0,0, ImageView.ScaleType.CENTER_CROP);
    }
    /**
     * 初始化视图界面
     */
    private void initView() {
        mIvAdertisement= findViewById(R.id.iv_advertisement);
        mSkipButtonView=findViewById(R.id.sbv_skip_view);

        mIsFrist=SharedpreferencesUtil.getBoolean(UiUtils.getContext(),MyConstaints.ISFIRST,true);
        mSkipButtonView.setOnClickSkipButtonViewListener(new OnSkipButtonViewListener() {
            @Override
            public void onClickSkipButton(View view) {
                mMyHandler.removeCallbacks(reshSkipButtonRunnable);
                if(mIsFrist){
                    //第一次启动进入导航页面
                    StartActivity.startActivity(SplashActivity.this,NavigationActivity.class,true);
                }else{
                    //不是第一次启动进入主页面
                    StartActivity.startActivity(SplashActivity.this,HomeActivity.class,true);
                }
            }
        });

        //刷新的次数
        total=timeLength/space;

        mMyHandler=new MyHandler(this);
    }
    /**
     * 按返回键停止绘制
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mMyHandler.removeCallbacks(reshSkipButtonRunnable);
        mMyHandler.removeMessages(1);
    }
    /**
     * Activity暂停的时候移除
     */
    @Override
    protected void onPause() {
        super.onPause();
        mMyHandler.removeCallbacks(reshSkipButtonRunnable);
        mMyHandler.removeMessages(1);
    }
    /**Activity重新启动时重新发消息
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        mMyHandler.post(reshSkipButtonRunnable);
        mMyHandler.sendEmptyMessageDelayed(1,3000);
    }
    /**
     * 自定义Handler
     */
    static class MyHandler extends Handler {
        SoftReference<SplashActivity>  activity;

        public MyHandler(SplashActivity activity){
            this.activity=new SoftReference<SplashActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            //获取SplashActivity
            SplashActivity splashActivity=activity.get();
            switch (msg.what){
                case 0:
                    int now=msg.arg1;
                    if(now<=splashActivity.total){
                        splashActivity.mSkipButtonView.setProgess(splashActivity.total,now);
                    }else{
                        this.removeCallbacks(splashActivity.reshSkipButtonRunnable);
                        if(splashActivity.mIsFrist){
                            //第一次启动进入导航页面
                            StartActivity.startActivity(splashActivity,NavigationActivity.class,true);
                        }else{
                            //不是第一次启动直接进入主页面
                            StartActivity.startActivity(splashActivity,HomeActivity.class,true);
                        }
                    }
                    break;
                case 1:
                    if(splashActivity.mIsFrist){
                        //第一次启动进入导航页面
                        StartActivity.startActivity(splashActivity,NavigationActivity.class,true);
                    }else{
                        //不是第一次启动直接进入主页面
                        StartActivity.startActivity(splashActivity,HomeActivity.class,true);
                    }
                    break;
            }
        }
    }
}
