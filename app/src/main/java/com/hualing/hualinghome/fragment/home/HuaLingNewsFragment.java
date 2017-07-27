package com.hualing.hualinghome.fragment.home;

import android.view.View;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**华领号外
 * Created by Administrator on 2017/7/22.
 */

public class HuaLingNewsFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        System.out.println("HuaLingNewsFragment:----->onCreateLoadSuccesView");
        return UiUtils.inflate(R.layout.fragment_hualingnews);
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        System.out.println("HuaLingNewsFragment:----->onLoadData");
        return BaseViewLoadPage.ResultState.LOAD_SUCCES;
    }
}
