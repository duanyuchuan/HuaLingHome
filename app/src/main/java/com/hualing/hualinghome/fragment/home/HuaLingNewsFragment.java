package com.hualing.hualinghome.fragment.home;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import com.hualing.hualinghome.adapter.HuaLingNewsAdapter;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.bean.HuaLingNewsHot;
import com.hualing.hualinghome.controller.HuaLingNewsController;
import com.hualing.hualinghome.fragment.BaseFragment;
import com.hualing.hualinghome.listener.INetWorkDataChangeListener;
import com.hualing.hualinghome.utils.DiyAction;
import com.hualing.hualinghome.utils.UiUtils;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**华领号外
 * Created by Administrator on 2017/7/22.
 */

public class HuaLingNewsFragment extends BaseFragment implements INetWorkDataChangeListener{
    private ArrayList<String> mList=new ArrayList<String>();
    private HuaLingNewsController mHuaLingNewsController;
    private MyHandler mMyHandler;

    @Override
    public View onCreateLoadSuccesView() {
        ListView listView=new ListView(UiUtils.getContext());
        //初始化数据
        initData();
        HuaLingNewsAdapter adapter=new HuaLingNewsAdapter(mList);
        listView.setAdapter(adapter);
        return listView;
    }

    @Override
    public BaseViewLoadPage.ResultState onLoadData() {
        System.out.println("HuaLingNewsFragment:----->onLoadData");
        mHuaLingNewsController=new HuaLingNewsController();
        mHuaLingNewsController.setINetWorkDataChangeListener(this);
        mHuaLingNewsController.sendAsyncRequestData(DiyAction.HUALINGNEWS_ACTION);

        mMyHandler=new MyHandler(this);
        return BaseViewLoadPage.ResultState.LOAD_SUCCES;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mList.clear();
        for(int i=0;i<10;i++){
            mList.add("更换测+++++++++xxxxxxxx++++++++试数据"+i);
        }
    }

    @Override
    public void onNetWorkDataChange(int action, Object... values) {
        //子线程运行
        mMyHandler.obtainMessage(action,values[0]).sendToTarget();
    }

    /**
     * 自定义handler
     */
    class MyHandler extends Handler{
        private SoftReference<HuaLingNewsFragment> fragment;

        public MyHandler(HuaLingNewsFragment fragment){
            this.fragment=new SoftReference<HuaLingNewsFragment>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            HuaLingNewsFragment huaLingNewsFragment = fragment.get();
            switch (msg.what){
                case DiyAction.HUALINGNEWS_ACTION_RESULT:
                    handleHuaLingNewsResult(msg);
                    break;
            }
        }
    }
    /**
     * 在主线程处理从子线程返回回来的结果
     * @param msg
     */
    private void handleHuaLingNewsResult(Message msg) {
        HuaLingNewsHot huaLingNewsHot=(HuaLingNewsHot)msg.obj;
        if(huaLingNewsHot!=null){
            System.out.println(huaLingNewsHot.toString());
        }
    }
}
