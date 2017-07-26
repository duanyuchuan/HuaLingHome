package com.hualing.hualinghome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.hualing.hualinghome.bean.HomeFragmentInfo;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/25.
 */

public class MyHomeFragmentAdapter extends FragmentStatePagerAdapter{
    private ArrayList<HomeFragmentInfo> mPage;

    public MyHomeFragmentAdapter(FragmentManager fm,ArrayList<HomeFragmentInfo> page) {
        super(fm);
        this.mPage=page;
    }

    @Override
    public Fragment getItem(int position) {
        if(mPage.size()>0){
            return mPage.get(position).getFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mPage.size()>0 ? mPage.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(mPage.size()>0){
            return mPage.get(position).getTitle();
        }
        return "";
    }
}
