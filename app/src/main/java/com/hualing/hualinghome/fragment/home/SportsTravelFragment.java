package com.hualing.hualinghome.fragment.home;

import android.view.View;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**运动旅行
 * Created by Administrator on 2017/7/22.
 */

public class SportsTravelFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        return UiUtils.inflate(R.layout.fragment_sports_travel);
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        return BaseViewLoadPage.ResultState.STATE_ERROR;
    }
}
