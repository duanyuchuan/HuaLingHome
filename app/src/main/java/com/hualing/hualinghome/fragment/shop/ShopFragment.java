package com.hualing.hualinghome.fragment.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.adapter.MyShopFragmentPagerAdapter;
import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.bean.FragmentInfo;
import com.hualing.hualinghome.utils.UiUtils;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/20.
 */

public class ShopFragment extends BaseFragment{
    private ViewPager mViewPager;
    private SmartTabLayout mSmartTabLayout;
    private ArrayList<FragmentInfo> mShopFragmentData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shop, container, false);
        return rootView;
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
        FrameLayout layout = (FrameLayout)getActivity().findViewById(R.id.fl_shop_tabs);
        layout.addView(View.inflate(getActivity(),R.layout.shop_include_tab,null));

        mSmartTabLayout=(SmartTabLayout)getActivity().findViewById(R.id.st_shop_smart_tab);
        mViewPager=(ViewPager)getActivity().findViewById(R.id.vp_shop_content);

        String[] tabInfos = UiUtils.getResourcesStringArray(R.array.shop_tab);
        int length=tabInfos.length;
        for(int i=0;i<length;i++){
            FragmentInfo info;
            if(i==0){
                info=new FragmentInfo(new RecommendedFragment(),tabInfos[i]);
            }else{
                info= new FragmentInfo(new ActivityFragment(),tabInfos[i]);
            }
            mShopFragmentData.add(info);
        }

        MyShopFragmentPagerAdapter adpter=new MyShopFragmentPagerAdapter(getFragmentManager(),mShopFragmentData);
        mViewPager.setAdapter(adpter);
        mSmartTabLayout.setViewPager(mViewPager);
    }
    /**
     * 初始化数据
     */
    private void initData() {
        mShopFragmentData=new ArrayList<>();
    }
}
