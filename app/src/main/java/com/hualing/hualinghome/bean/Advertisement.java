package com.hualing.hualinghome.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/11.
 */

public class Advertisement implements Serializable{
    public String error;
    public int next_req;
    public int result;
    public int rolls;
    public ArrayList<AdvertisementDetail> ads=new ArrayList<AdvertisementDetail>();

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getNext_req() {
        return next_req;
    }

    public void setNext_req(int next_req) {
        this.next_req = next_req;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public ArrayList<AdvertisementDetail> getAds() {
        return ads;
    }

    public void setAds(ArrayList<AdvertisementDetail> ads) {
        this.ads = ads;
    }
}
