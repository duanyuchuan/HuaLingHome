package com.hualing.hualinghome.fragment.shop;

import android.view.View;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**华领严选
 * Created by Administrator on 2017/7/21.
 */

public class HuaLingSelectionFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        return UiUtils.inflate(R.layout.fragment_hualing_selection);
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        return BaseViewLoadPage.ResultState.STATE_SUCCES;
    }
}
