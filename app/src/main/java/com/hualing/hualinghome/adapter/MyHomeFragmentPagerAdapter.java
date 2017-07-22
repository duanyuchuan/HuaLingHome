package com.hualing.hualinghome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hualing.hualinghome.bean.HomeFragmentInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/21.
 */

public class MyHomeFragmentPagerAdapter extends FragmentStatePagerAdapter{
    private ArrayList<HomeFragmentInfo> mHomeFragmentData=new ArrayList<>();

    public MyHomeFragmentPagerAdapter(FragmentManager fm, ArrayList<HomeFragmentInfo> homeFragmentData) {
        super(fm);
        this.mHomeFragmentData=homeFragmentData;
    }
    @Override
    public int getCount() {
        return (mHomeFragmentData!=null && mHomeFragmentData.size()>0) ? mHomeFragmentData.size() : 0;
    }
    @Override
    public Fragment getItem(int position) {
        if(mHomeFragmentData != null && mHomeFragmentData.size()>0){
            return mHomeFragmentData.get(position).getFragment();
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if(mHomeFragmentData != null && mHomeFragmentData.size()>0) {
            return mHomeFragmentData.get(position).getTitle();
        }
        return "";
    }
}
