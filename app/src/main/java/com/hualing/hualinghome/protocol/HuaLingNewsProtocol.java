package com.hualing.hualinghome.protocol;

import com.hualing.hualinghome.utils.MyConstaints;

/**
 * Created by Administrator on 2017/7/29.
 */

public class HuaLingNewsProtocol extends BaseProtocol<Object>{

    @Override
    protected String getKey() {
        return MyConstaints.HUALING_NEWS_URL;
    }

    @Override
    protected Object parseJson(String result) {
        return null;
    }
}
