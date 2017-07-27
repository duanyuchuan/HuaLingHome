package com.hualing.hualinghome.fragment.shop;

import android.view.View;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**服装鞋靴
 * Created by Administrator on 2017/7/21.
 */

public class ClothingShoeFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        return UiUtils.inflate(R.layout.fragment_clothing_shoe);
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        return BaseViewLoadPage.ResultState.LOAD_SUCCES;
    }
}
