package com.hualing.hualinghome.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/11.
 */

public class AdvertisementDetail implements Serializable{
    public ArrayList<String> res_url=new ArrayList<String>();
    public ActionParams action_params;

    public ArrayList<String> getRes_url() {
        return res_url;
    }

    public void setRes_url(ArrayList<String> res_url) {
        this.res_url = res_url;
    }

    public ActionParams getAction_params() {
        return action_params;
    }

    public void setAction_params(ActionParams action_params) {
        this.action_params = action_params;
    }
}
