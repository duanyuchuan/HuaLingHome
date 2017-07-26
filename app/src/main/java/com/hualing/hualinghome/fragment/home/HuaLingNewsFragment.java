package com.hualing.hualinghome.fragment.home;

import android.view.View;
import android.widget.TextView;

import com.hualing.hualinghome.base.BaseFragment;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;

/**华领号外
 * Created by Administrator on 2017/7/22.
 */

public class HuaLingNewsFragment extends BaseFragment{

    @Override
    public View onCreateLoadSuccesView() {
        TextView textView=new TextView(UiUtils.getContext());
        textView.setText("华领外号............");
        return textView;
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {


        //ArrayList<String> data=new ArrayList<>();
        return BaseViewLoadPage.ResultState.LOAD_SUCCES;
    }
}
