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
import com.hualing.hualinghome.bean.HomeFragmentInfo;
import com.hualing.hualinghome.fragment.shop.ActivityFragment;
import com.hualing.hualinghome.fragment.shop.RecommendedFragment;
import com.hualing.hualinghome.utils.UiUtils;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/20.
 */

public class HomeFragment extends BaseFragment {
    private ViewPager mViewPager;
    private SmartTabLayout mSmartTabLayout;
    private ArrayList<HomeFragmentInfo> mHomeFragmentData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化数据
        initData();
        //初始化视图
        initView();
    }
    /**
     * 初始化视图
     */
    private void initView() {
        FrameLayout layout = (FrameLayout)getActivity().findViewById(R.id.fl_home_tabs);
        layout.addView(View.inflate(getActivity(),R.layout.home_include_tab,null));

        mSmartTabLayout=(SmartTabLayout)getActivity().findViewById(R.id.st_home_smart_tab);
        mViewPager=(ViewPager)getActivity().findViewById(R.id.vp_home_content_page);

        String[] tabInfos = UiUtils.getResourcesStringArray(R.array.home_tab);
        int length=tabInfos.length;
        for(int i=0;i<length;i++){
            HomeFragmentInfo info;
            if(i==0){
                info=new HomeFragmentInfo(new RecommendedFragment(),tabInfos[i]);
            }else{
                info= new HomeFragmentInfo(new ActivityFragment(),tabInfos[i]);
            }
            mHomeFragmentData.add(info);
        }

        MyHomeFragmentPagerAdapter adpter=new MyHomeFragmentPagerAdapter(getFragmentManager(),mHomeFragmentData);
        mViewPager.setAdapter(adpter);
        mSmartTabLayout.setViewPager(mViewPager);
    }
    /**
     * 初始化数据
     */
    private void initData() {
        mHomeFragmentData=new ArrayList<>();
    }
}
