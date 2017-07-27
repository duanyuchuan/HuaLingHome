package com.hualing.hualinghome.fragment.home;

import android.view.View;
import android.widget.ListView;

import com.hualing.hualinghome.adapter.HuaLingNewsAdapter;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.utils.UiUtils;

import java.util.ArrayList;

/**华领号外
 * Created by Administrator on 2017/7/22.
 */

public class HuaLingNewsFragment extends BaseFragment{
    private ArrayList<String> mList=new ArrayList<String>();

    @Override
    public View onCreateLoadSuccesView() {
        ListView listView=new ListView(UiUtils.getContext());
        //初始化数据
        initData();
        HuaLingNewsAdapter adapter=new HuaLingNewsAdapter(mList);
        listView.setAdapter(adapter);
        return listView;
    }
    /**
     * 初始化数据
     */
    private void initData() {
        for(int i=0;i<50;i++){
            mList.add("更换测+++++++++xxxxxxxx++++++++试数据"+i);
        }
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        System.out.println("HuaLingNewsFragment:----->onLoadData");
        return BaseViewLoadPage.ResultState.LOAD_SUCCES;
    }
}
