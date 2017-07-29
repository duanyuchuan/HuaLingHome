package com.hualing.hualinghome.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/29.
 */

public class HuaLingNewsHotDetail {
    private ArrayList<HuaLingNewsBanner> ads;
    private String img;
    private String title;
    private String source;
    private int replyCount;
    private String replyid;

    public ArrayList<HuaLingNewsBanner> getAds() {
        return ads;
    }

    public void setAds(ArrayList<HuaLingNewsBanner> ads) {
        this.ads = ads;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getReplyid() {
        return replyid;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    @Override
    public String toString() {
        return "HuaLingNewsHotDetail{" +
                "ads=" + ads +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", replyCount=" + replyCount +
                ", replyid='" + replyid + '\'' +
                '}';
    }
}
