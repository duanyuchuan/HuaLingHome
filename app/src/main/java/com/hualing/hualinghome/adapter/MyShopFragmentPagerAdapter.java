package com.hualing.hualinghome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hualing.hualinghome.bean.FragmentInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/21.
 */

public class MyShopFragmentPagerAdapter extends FragmentStatePagerAdapter{
    private ArrayList<FragmentInfo> mShopFragmentData=new ArrayList<>();

    public MyShopFragmentPagerAdapter(FragmentManager fm,ArrayList<FragmentInfo> shopFragmentData) {
        super(fm);
        this.mShopFragmentData=shopFragmentData;
    }
    @Override
    public int getCount() {
        return (mShopFragmentData!=null && mShopFragmentData.size()>0) ? mShopFragmentData.size() : 0;
    }
    @Override
    public Fragment getItem(int position) {
        if(mShopFragmentData != null && mShopFragmentData.size()>0){
            return mShopFragmentData.get(position).getFragment();
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if(mShopFragmentData != null && mShopFragmentData.size()>0) {
            return mShopFragmentData.get(position).getTitle();
        }
        return "";
    }
}
