package com.hualing.hualinghome.fragment.shop;

import android.view.View;
import android.widget.EditText;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**活动
 * Created by Administrator on 2017/7/21.
 */

public class ActivityFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        View rootView = UiUtils.inflate(R.layout.fragment_activity);
        EditText textView = rootView.findViewById(R.id.tv_activity);
        System.out.println("onCreateLoadSuccesView:");
        return rootView;
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        System.out.println("onLoadData:");
        return BaseViewLoadPage.ResultState.LOAD_SUCCES;
    }
}
