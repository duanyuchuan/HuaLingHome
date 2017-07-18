package com.hualing.hualinghome.fragment;
import com.cleveroad.slidingtutorial.PageFragment;
import com.cleveroad.slidingtutorial.TransformItem;
import com.hualing.hualinghome.R;

/**
 * Created by Administrator on 2017/7/17.
 */

public class SecondCustomPageFragment extends PageFragment {

    //获取布局文件的ID
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_page_second;
    }

    @Override
    protected int getBackgroundColorResId() {
        return android.R.color.holo_blue_light;
    }

    @Override
    public int getRootResId() {
        return R.id.rootSecondPage;
    }

    /*为界面上的各个元素设置移动因素，包括方向和系数。
    一个TransformItem就是一个界面元素，其中它的第一个参数是界面元素对应的id，
    第二个参数是是否反向，true表示要，false表示不，第三个参数是移动系数。
    系数越大移动越慢，为一个界面上的不同元素设置不同的方向和系数，就能形成视差效果。
    **/
    @Override
    protected TransformItem[] provideTransformItems() {
        return new TransformItem[]{
                new TransformItem(R.id.ivFirstImage, true, 20),
                new TransformItem(R.id.ivSecondImage, false, 6),
                new TransformItem(R.id.ivThirdImage, true, 8),
        };
    }
}
