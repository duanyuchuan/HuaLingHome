package com.hualing.hualinghome.controller;

import com.hualing.hualinghome.HttpUtils.NetworkUtil;
import com.hualing.hualinghome.bean.HuaLingNewsHot;
import com.hualing.hualinghome.utils.DiyAction;
import com.hualing.hualinghome.utils.JsonUtil;
import com.hualing.hualinghome.utils.MyConstaints;

/**
 * Created by Administrator on 2017/7/29.
 */

public class HuaLingNewsController extends BaseController{

    @Override
    protected void handleAsyncRequest(int action, Object[] values) {
        switch (action){
            case DiyAction.HUALINGNEWS_ACTION:
                HuaLingNewsHot huaLingNewsHot=getHuaLingNewsData(MyConstaints.HUALING_NEWS_URL);
                mINetWorkDataChangeListener.onNetWorkDataChange(DiyAction.HUALINGNEWS_ACTION_RESULT,huaLingNewsHot);
                break;
        }
    }

    /**
     * 获取网络数据返回Json对象
     * @param hualingNewsUrl
     * @return
     */
    private HuaLingNewsHot getHuaLingNewsData(String hualingNewsUrl) {
        String jsonString = NetworkUtil.doGet(hualingNewsUrl);
        return JsonUtil.parseJson(jsonString, HuaLingNewsHot.class);
    }
}
