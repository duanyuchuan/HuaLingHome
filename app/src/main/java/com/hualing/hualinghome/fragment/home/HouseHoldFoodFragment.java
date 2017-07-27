package com.hualing.hualinghome.fragment.home;

import android.view.View;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**家居美食
 * Created by Administrator on 2017/7/22.
 */

public class HouseHoldFoodFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        return UiUtils.inflate(R.layout.fragment_house_hold_food);
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        return BaseViewLoadPage.ResultState.LOAD_EMPTY;
    }
}
