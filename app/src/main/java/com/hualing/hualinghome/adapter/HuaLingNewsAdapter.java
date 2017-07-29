package com.hualing.hualinghome.adapter;

import android.os.SystemClock;

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
    public ArrayList<String> onLoadMore() {
        //模拟测试更多数据
        ArrayList<String> moreData=new ArrayList<String>();
        moreData.clear();
        for(int i=15;i<25;i++){
            moreData.add("更多测试数据"+i);
        }
        //模拟耗时操作
        SystemClock.sleep(2000);
        return moreData;
    }

    @Override
    protected BaseHolderView<String> getHolder(int position) {
        return new HuaLingNewsHolderView();
    }
}
