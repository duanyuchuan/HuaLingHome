package com.hualing.hualinghome.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseActivity;
import com.hualing.hualinghome.bean.ActionParams;

/**
 * Created by Administrator on 2017/7/15.
 */

public class WebViewActivity extends BaseActivity {
    public static final String WEBVIEW_ACTIVITY="WebViewActivity";
    private WebView mWebView;
    private ActionParams mActionParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //引用布局控件
        mWebView = findViewById(R.id.wv_advertisement);
        //获取传递过来的数据
        mActionParams = (ActionParams)getIntent().getSerializableExtra(WEBVIEW_ACTIVITY);
        //界面的展示
        initView();
    }
    /**
     * 界面的展示
     */
    private void initView() {
        String linkUrl = mActionParams.getLink_url();
        if(!TextUtils.isEmpty(linkUrl)){
            //设置全屏显示
            mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            mWebView.getSettings().setUseWideViewPort(true);
            mWebView.getSettings().setLoadWithOverviewMode(true);

            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.loadUrl(linkUrl);
            //取消设置重定向
            mWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }
    }
    /**
     * 处理返回键
     */
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
            return;
        }
        super.onBackPressed();
    }
}
