package com.hualing.hualinghome.business;

import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.fragment.home.EntertainmentFragment;
import com.hualing.hualinghome.fragment.home.FashionFragment;
import com.hualing.hualinghome.fragment.home.HouseHoldFoodFragment;
import com.hualing.hualinghome.fragment.home.HuaLingNewsFragment;
import com.hualing.hualinghome.fragment.home.LiveMicroLifeFragment;
import com.hualing.hualinghome.fragment.home.MaternalAndInfantFragment;
import com.hualing.hualinghome.fragment.home.ProtectSkinFragment;
import com.hualing.hualinghome.fragment.home.SportsTravelFragment;

import java.util.HashMap;

/**创建主页面fragment的工厂
 * Created by Administrator on 2017/7/24.
 */

public class HomeFragmentFactory {
    //存储创建的fragment对象
    private static HashMap<Integer,BaseFragment> sFragmentHashMap=new HashMap<Integer,BaseFragment>();
    /**
     * 根据位置创建fragment对象
     * @param position
     * @return
     */
    public static BaseFragment createFragment(int position){
        BaseFragment fragment = sFragmentHashMap.get(position);
        if(fragment==null){
            switch (position){
                case 0:
                    fragment=new HuaLingNewsFragment();
                    break;
                case 1:
                    fragment=new FashionFragment();
                    break;
                case 2:
                    fragment=new ProtectSkinFragment();
                    break;
                case 3:
                    fragment=new MaternalAndInfantFragment();
                    break;
                case 4:
                    fragment=new SportsTravelFragment();
                    break;
                case 5:
                    fragment=new EntertainmentFragment();
                    break;
                case 6:
                    fragment=new HouseHoldFoodFragment();
                    break;
                case 7:
                    fragment=new LiveMicroLifeFragment();
                    break;
                default:
                    break;
            }
            sFragmentHashMap.put(position,fragment);
        }
        return fragment;
    }
}
