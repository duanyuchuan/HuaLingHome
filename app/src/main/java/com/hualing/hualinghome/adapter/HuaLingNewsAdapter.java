package com.hualing.hualinghome.adapter;

import com.hualing.hualinghome.holder.BaseHolderView;
import com.hualing.hualinghome.holder.HuaLingNewsHolderView;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/27.
 */

public class HuaLingNewsAdapter extends MyListViewBaseAdapter<String>{

    public HuaLingNewsAdapter(ArrayList<String> data) {
        super(data);
    }

    @Override
    protected BaseHolderView<String> getHolder(int position) {
        return new HuaLingNewsHolderView();
    }
}
