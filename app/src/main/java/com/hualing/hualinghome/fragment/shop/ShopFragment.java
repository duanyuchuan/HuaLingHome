package com.hualing.hualinghome.fragment.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.adapter.MyShopFragmentPagerAdapter;
import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.bean.ShopFragmentInfo;
import com.hualing.hualinghome.utils.UiUtils;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import java.util.ArrayList;

/**购物模块
 * Created by Administrator on 2017/7/20.
 */

public class ShopFragment extends Fragment{
    private ViewPager mViewPager;
    private SmartTabLayout mSmartTabLayout;
    private ArrayList<ShopFragmentInfo> mPages;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化视图
        initView();
        //监听事件
        initEvent();
    }
    /**
     * 初始化视图
     */
    private void initView() {
        FrameLayout layout = (FrameLayout)getActivity().findViewById(R.id.fl_shop_tabs);
        layout.addView(View.inflate(getActivity(),R.layout.shop_include_tab,null));
        mSmartTabLayout=(SmartTabLayout)getActivity().findViewById(R.id.st_shop_smart_tab);
        mViewPager=(ViewPager)getActivity().findViewById(R.id.vp_shop_content);

        mPages=new ArrayList<ShopFragmentInfo>();
        String[] shopTabs = UiUtils.getResourcesStringArray(R.array.shop_tab);
        int size=shopTabs.length;
        for(int i=0;i<size;i++){
            switch (i){
                case 0:
                    mPages.add(new ShopFragmentInfo(new RecommendedFragment(),shopTabs[i]));
                    break;
                case 1:
                    mPages.add(new ShopFragmentInfo(new ActivityFragment(),shopTabs[i]));
                    break;
                case 2:
                    mPages.add(new ShopFragmentInfo(new GlobalFragment(),shopTabs[i]));
                    break;
                case 3:
                    mPages.add(new ShopFragmentInfo(new HuaLingSelectionFragment(),shopTabs[i]));
                    break;
                case 4:
                    mPages.add(new ShopFragmentInfo(new MaternalFragment(),shopTabs[i]));
                    break;
                case 5:
                    mPages.add(new ShopFragmentInfo(new BeautyFragment(),shopTabs[i]));
                    break;
                case 6:
                    mPages.add(new ShopFragmentInfo(new BagsFragment(),shopTabs[i]));
                    break;
                case 7:
                    mPages.add(new ShopFragmentInfo(new FoodAndHealthFragment(),shopTabs[i]));
                    break;
                case 8:
                    mPages.add(new ShopFragmentInfo(new HouseHoldFragment(),shopTabs[i]));
                    break;
                case 9:
                    mPages.add(new ShopFragmentInfo(new DirectFragment(),shopTabs[i]));
                    break;
                case 10:
                    mPages.add(new ShopFragmentInfo(new RemoteOutdoorFragment(),shopTabs[i]));
                    break;
                case 11:
                    mPages.add(new ShopFragmentInfo(new ClothingShoeFragment(),shopTabs[i]));
                    break;
                case 12:
                    mPages.add(new ShopFragmentInfo(new FreshFragment(),shopTabs[i]));
                    break;
                case 13:
                    mPages.add(new ShopFragmentInfo(new PavilionFragment(),shopTabs[i]));
                    break;
            }
        }

        MyShopFragmentPagerAdapter adpter=new MyShopFragmentPagerAdapter(getFragmentManager(),mPages);
        mViewPager.setAdapter(adpter);
        mSmartTabLayout.setViewPager(mViewPager);
    }
    /**
     * 监听事件
     */
    public void initEvent(){
        //设置页面的滑动监听事件
        mSmartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = (BaseFragment) mPages.get(position).getFragment();
                fragment.loadData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
