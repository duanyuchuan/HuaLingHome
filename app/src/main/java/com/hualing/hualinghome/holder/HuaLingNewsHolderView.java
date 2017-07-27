package com.hualing.hualinghome.holder;

import android.view.View;
import android.widget.TextView;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.utils.UiUtils;

/**
 * Created by Administrator on 2017/7/27.
 */

public class HuaLingNewsHolderView extends BaseHolderView<String>{
    private TextView mTextView;

    @Override
    protected View initView() {
        View rootView = View.inflate(UiUtils.getContext(), R.layout.item_hualing_news, null);
        mTextView=rootView.findViewById(R.id.tv_item_list);
        return rootView;
    }

    @Override
    protected void refreshView(String data) {
        mTextView.setText(data);
    }

}
