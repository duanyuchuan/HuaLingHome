package com.hualing.hualinghome.bean;

import android.os.Bundle;

/**
 * Created by Administrator on 2017/7/21.
 */

public class SmartTabInfo {
    public String mTitle;
    public Class mClazz;
    public Bundle mBundle;
    public SmartTabInfo(String title, Class clazz, Bundle bundle) {
        this.mTitle = title;
        this.mClazz = clazz;
        this.mBundle = bundle;
    }
}
