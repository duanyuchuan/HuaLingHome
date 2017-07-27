package com.hualing.hualinghome.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/7/15.
 */

public class BaseActivity extends FragmentActivity {
    private boolean mflags=true;
    private boolean mIsNoTitleBar=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setFullScrean(mflags);
        super.onCreate(savedInstanceState);

    }

    /**
     * 设置沉浸式
     */
    public void setNoTitleBar(boolean isNoTitleBar){
        this.mIsNoTitleBar=isNoTitleBar;
        if(mIsNoTitleBar){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
                localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            }
        }
    }
    /**
     * 设置全屏
     */
    public void setFullScrean(boolean flags){
        this.mflags=flags;
        if(mflags){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}
