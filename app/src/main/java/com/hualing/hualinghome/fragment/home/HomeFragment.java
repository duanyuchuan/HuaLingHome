package com.hualing.hualinghome.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.adapter.MyHomeFragmentPagerAdapter;
import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.business.HomeFragmentFactory;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * Created by Administrator on 2017/7/20.
 */

public class HomeFragment extends BaseFragment {
    private ViewPager mViewPager;
    private SmartTabLayout mSmartTabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public View onCreateLoadSuccesView() {
        return null;
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化视图
        initView();
        //监听事件事件
        initEnvent();
    }
    /**
     * 初始化视图
     */
    private void initView() {
        FrameLayout layout = (FrameLayout)getActivity().findViewById(R.id.fl_home_tabs);
        layout.addView(View.inflate(getActivity(),R.layout.home_include_tab,null));

        mSmartTabLayout=(SmartTabLayout)getActivity().findViewById(R.id.st_home_smart_tab);
        mViewPager=(ViewPager)getActivity().findViewById(R.id.vp_home_content_page);

        MyHomeFragmentPagerAdapter adpter=new MyHomeFragmentPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(adpter);
        mSmartTabLayout.setViewPager(mViewPager);
    }
    /**
     * 监听事件事件
     */
    public void initEnvent(){
        //设置ViewPage的滑动监听对象
        mSmartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = HomeFragmentFactory.createFragment(position);
                fragment.startLoadDataFromNetWork();
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
