package com.hualing.hualinghome.business;

import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.fragment.shop.ActivityFragment;
import com.hualing.hualinghome.fragment.shop.BagsFragment;
import com.hualing.hualinghome.fragment.shop.BeautyFragment;
import com.hualing.hualinghome.fragment.shop.ClothingShoeFragment;
import com.hualing.hualinghome.fragment.shop.DirectFragment;
import com.hualing.hualinghome.fragment.shop.FoodAndHealthFragment;
import com.hualing.hualinghome.fragment.shop.FreshFragment;
import com.hualing.hualinghome.fragment.shop.GlobalFragment;
import com.hualing.hualinghome.fragment.shop.HouseHoldFragment;
import com.hualing.hualinghome.fragment.shop.HuaLingSelectionFragment;
import com.hualing.hualinghome.fragment.shop.MaternalFragment;
import com.hualing.hualinghome.fragment.shop.PavilionFragment;
import com.hualing.hualinghome.fragment.shop.RecommendedFragment;
import com.hualing.hualinghome.fragment.shop.RemoteOutdoorFragment;
import java.util.HashMap;

/**创建Fragment的工厂类
 * Created by Administrator on 2017/7/21.
 */

public class ShopFragmentFactory {
    //存放Fragment的集合
    private static HashMap<Integer,BaseFragment> mFragmentMap=new HashMap<Integer,BaseFragment>();
    /**
     * 生成Fragment的方法
     * @param position
     */
    public static BaseFragment createFragment(int position){
        BaseFragment fragment= mFragmentMap.get(position);
        if(fragment==null){
            switch (position){
                case 0:
                    fragment=new RecommendedFragment();
                    break;
                case 1:
                    fragment=new ActivityFragment();
                    break;
                case 2:
                    fragment=new GlobalFragment();
                    break;
                case 3:
                    fragment=new HuaLingSelectionFragment();
                    break;
                case 4:
                    fragment=new MaternalFragment();
                    break;
                case 5:
                    fragment=new BeautyFragment();
                    break;
                case 6:
                    fragment=new BagsFragment();
                    break;
                case 7:
                    fragment=new FoodAndHealthFragment();
                    break;
                case 8:
                    fragment=new HouseHoldFragment();
                    break;
                case 9:
                    fragment=new DirectFragment();
                    break;
                case 10:
                    fragment=new RemoteOutdoorFragment();
                    break;
                case 11:
                    fragment=new ClothingShoeFragment();
                    break;
                case 12:
                    fragment=new FreshFragment();
                    break;
                case 13:
                    fragment=new PavilionFragment();
                    break;
            }
            mFragmentMap.put(position,fragment);
        }
        return fragment;
    }
}
