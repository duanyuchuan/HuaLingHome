package com.hualing.hualinghome.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.adapter.MyHomeFragmentAdapter;
import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.bean.HomeFragmentInfo;
import com.hualing.hualinghome.utils.UiUtils;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/20.
 */

public class HomeFragment extends Fragment {
    private SmartTabLayout mSmartTabLayout;
    private ViewPager mViewPager;
    private ArrayList<HomeFragmentInfo> mPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //System.out.println("HomeFragment:<----->onActivityCreated");
        //初始化视图
        initView();
        //监听事件
        initEvent();
    }
    /**
     * 初始化视图
     */
    private void initView() {
        FrameLayout layout = (FrameLayout)getActivity().findViewById(R.id.fl_home_tabs);
        layout.addView(View.inflate(getActivity(),R.layout.home_include_tab,null));
        mSmartTabLayout=(SmartTabLayout)getActivity().findViewById(R.id.st_home_smart_tab);
        mViewPager=(ViewPager)getActivity().findViewById(R.id.vp_home_content_page);

        mPage=new ArrayList<HomeFragmentInfo>();
        String[] titleTabs = UiUtils.getResourcesStringArray(R.array.home_tab);
        int size=titleTabs.length;
        for(int i=0;i<size;i++){
            switch (i){
                case 0:
                    mPage.add(new HomeFragmentInfo(new HuaLingNewsFragment(),titleTabs[i]));
                    break;
                case 1:
                    mPage.add(new HomeFragmentInfo(new FashionFragment(),titleTabs[i]));
                    break;
                case 2:
                    mPage.add(new HomeFragmentInfo(new ProtectSkinFragment(),titleTabs[i]));
                    break;
                case 3:
                    mPage.add(new HomeFragmentInfo(new MaternalAndInfantFragment(),titleTabs[i]));
                    break;
                case 4:
                    mPage.add(new HomeFragmentInfo(new SportsTravelFragment(),titleTabs[i]));
                    break;
                case 5:
                    mPage.add(new HomeFragmentInfo(new EntertainmentFragment(),titleTabs[i]));
                    break;
                case 6:
                    mPage.add(new HomeFragmentInfo(new HouseHoldFoodFragment(),titleTabs[i]));
                    break;
                case 7:
                    mPage.add(new HomeFragmentInfo(new LiveMicroLifeFragment(),titleTabs[i]));
                    break;
            }
        }

        MyHomeFragmentAdapter adpter=new MyHomeFragmentAdapter(getFragmentManager(),mPage);
        mViewPager.setAdapter(adpter);
        mSmartTabLayout.setViewPager(mViewPager);
    }
    /**
     * 监听事件
     */
    private void initEvent() {
        //设置滑动事件
        mSmartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = (BaseFragment)mPage.get(position).getFragment();
                fragment.loadData();
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
