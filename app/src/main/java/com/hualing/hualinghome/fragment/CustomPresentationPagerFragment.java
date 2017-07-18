package com.hualing.hualinghome.fragment;

import com.cleveroad.slidingtutorial.PageFragment;
import com.cleveroad.slidingtutorial.PresentationPagerFragment;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.utils.UiUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class CustomPresentationPagerFragment {
    //获取页面个数
    @Override
    protected int getPagesCount() {
        return 3;
    }
    //注意此处是背景上所添加的图案的循环出现的次数，运行安装后可以发现第一个页面（position=0）的图案和第四个（position=3）是相同的就是在此处设置的
    @Override
    protected PageFragment getPage(int position) {
        position %= 3;
        if (position == 0)
            return new FirstCustomPageFragment();
        if (position == 1)
            return new SecondCustomPageFragment();
        if (position == 2)
            return new ThirdCustomPageFragment();
        throw new IllegalArgumentException("Unknown position: " + position);
    }
    //设置背景颜色，现在越来越多的软件背景都是以颜色代替呈现一种扁平化的感觉，也可以自定义图片
    @ColorInt
    @Override
    protected int getPageColor(int position) {
        if (position == 0)
            return ContextCompat.getColor(UiUtils.getContext(), android.R.color.holo_orange_dark);
        if (position == 1)
            return ContextCompat.getColor(UiUtils.getContext(), android.R.color.holo_green_dark);
        if (position == 2)
            return ContextCompat.getColor(UiUtils.getContext(), android.R.color.holo_blue_dark);
        if (position == 3)
            return ContextCompat.getColor(UiUtils.getContext(), android.R.color.holo_red_dark);
        if (position == 4)
            return ContextCompat.getColor(UiUtils.getContext(), android.R.color.holo_purple);
        if (position == 5)
            return ContextCompat.getColor(UiUtils.getContext(), android.R.color.darker_gray);
        return Color.TRANSPARENT;
    }
    //是否循环滑动（true一直循环滑动不进入程序，false相反）
    @Override
    protected boolean isInfiniteScrollEnabled() {
        return true;
    }
    //监听事件（页面上左下角Skip的点击事件---布局代码都在库文件中不可修改但是如果需要自己定义点击图标以及事件可以继承其抽象类的抽象方法去实现
    @Override
    protected boolean onSkipButtonClicked(View skipButton) {
        Toast.makeText(UiUtils.getContext(), "Skip button clicked", Toast.LENGTH_SHORT).show();
        return true;
    }
}
