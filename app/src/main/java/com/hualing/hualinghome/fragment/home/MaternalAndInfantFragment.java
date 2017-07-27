package com.hualing.hualinghome.fragment.home;

import android.view.View;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**母婴
 * Created by Administrator on 2017/7/22.
 */

public class MaternalAndInfantFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        return UiUtils.inflate(R.layout.fragment_maternal_infant);
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        return BaseViewLoadPage.ResultState.LOAD_SUCCES;
    }
}
