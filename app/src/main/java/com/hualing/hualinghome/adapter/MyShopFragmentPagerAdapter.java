package com.hualing.hualinghome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.hualing.hualinghome.bean.ShopFragmentInfo;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/21.
 */

public class MyShopFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<ShopFragmentInfo> mPages;

    public MyShopFragmentPagerAdapter(FragmentManager fm,ArrayList<ShopFragmentInfo> pages) {
        super(fm);
        this.mPages=pages;
    }

    @Override
    public Fragment getItem(int position) {
        if(mPages.size()>0){
            return mPages.get(position).getFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mPages.size()>0 ? mPages.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(mPages.size()>0){
            return mPages.get(position).getTitle();
        }
        return null;
    }
}
