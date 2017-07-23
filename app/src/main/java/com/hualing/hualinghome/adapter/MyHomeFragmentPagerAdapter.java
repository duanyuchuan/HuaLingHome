package com.hualing.hualinghome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.business.HomeFragmentFactory;
import com.hualing.hualinghome.utils.UiUtils;

/**
 * Created by Administrator on 2017/7/21.
 */

public class MyHomeFragmentPagerAdapter extends FragmentStatePagerAdapter{
    private String[] tabInfos ;

    public MyHomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        tabInfos = UiUtils.getResourcesStringArray(R.array.home_tab);
    }
    @Override
    public int getCount() {
        return (tabInfos.length>0) ? tabInfos.length : 0;
    }
    @Override
    public Fragment getItem(int position) {
        return HomeFragmentFactory.createFragment(position);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabInfos[position];
    }
}
