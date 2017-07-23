package com.hualing.hualinghome.business;

import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.fragment.home.EntertainmentFragment;
import com.hualing.hualinghome.fragment.home.FashionFragment;
import com.hualing.hualinghome.fragment.home.HouseHoldFoodFragment;
import com.hualing.hualinghome.fragment.home.HuaLingNewsFragment;
import com.hualing.hualinghome.fragment.home.LiveMicroLifeFragment;
import com.hualing.hualinghome.fragment.home.MaternalAndInfantFragment;
import com.hualing.hualinghome.fragment.home.ProtectSkinFragment;
import com.hualing.hualinghome.fragment.home.SportsTravelFragment;

import java.util.HashMap;

/**创建Fragment的工厂类
 * Created by Administrator on 2017/7/21.
 */

public class HomeFragmentFactory {
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
                    //华领号外
                    fragment=new HuaLingNewsFragment();
                    break;
                case 1:
                    //时尚
                    fragment=new FashionFragment();
                    break;
                case 2:
                    //彩妆护肤
                    fragment=new ProtectSkinFragment();
                    break;
                case 3:
                    //母婴
                    fragment=new MaternalAndInfantFragment();
                    break;
                case 4:
                    //运动旅行
                    fragment=new SportsTravelFragment();
                    break;
                case 5:
                    //娱乐
                    fragment=new EntertainmentFragment();
                    break;
                case 6:
                    //家居美食
                    fragment=new HouseHoldFoodFragment();
                    break;
                case 7:
                    //直播微生活
                    fragment=new LiveMicroLifeFragment();
                    break;
            }
            mFragmentMap.put(position,fragment);
        }
        return fragment;
    }
}
