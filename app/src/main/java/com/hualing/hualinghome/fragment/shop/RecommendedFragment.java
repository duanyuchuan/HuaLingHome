package com.hualing.hualinghome.fragment.shop;

import android.view.View;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**推荐
 * Created by Administrator on 2017/7/21.
 */

public class RecommendedFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        return UiUtils.inflate(R.layout.fragment_recommended);
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        return BaseViewLoadPage.ResultState.LOAD_SUCCES;
    }
}
