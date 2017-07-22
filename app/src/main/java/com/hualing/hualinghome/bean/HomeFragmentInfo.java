package com.hualing.hualinghome.bean;

import android.support.v4.app.Fragment;

/**
 * @author 小码哥Android学院(520it.com)
 * @time 2016/10/14  16:08
 * @desc ${TODD}
 */
public class HomeFragmentInfo {
    Fragment mFragment;
    String title;

    public HomeFragmentInfo(Fragment fragment, String title) {
        mFragment = fragment;
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

    @Override
    public String toString() {
        return "FragmentInfo{" +
                "mFragment=" + mFragment +
                ", title='" + title + '\'' +
                '}';
    }
}
