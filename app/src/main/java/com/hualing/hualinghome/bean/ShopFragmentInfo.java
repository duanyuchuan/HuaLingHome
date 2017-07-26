package com.hualing.hualinghome.bean;

import android.support.v4.app.Fragment;

/**
 * @author 小码哥Android学院(520it.com)
 * @time 2016/10/14  16:08
 * @desc ${TODD}
 */
public class ShopFragmentInfo {
    Fragment mFragment;
    String title;

    public ShopFragmentInfo(Fragment fragment, String title) {
        this.mFragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
