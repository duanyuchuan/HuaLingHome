package com.hualing.hualinghome.holder;

import android.view.View;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.utils.UiUtils;

/**
 * Created by Administrator on 2017/7/27.
 */

public class LoadMoreHolderView extends BaseHolderView{
    @Override
    protected View initView() {
        return UiUtils.inflate(R.layout.layout_load_more);
    }

    @Override
    protected void refreshView(Object data) {

    }
}
