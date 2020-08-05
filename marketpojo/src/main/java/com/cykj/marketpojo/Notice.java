package com.cykj.marketpojo;

import java.util.Date;

public class Notice {
    private int id;
    private String title;
    private String content;
    private String picUrl;
    private Date noticeTime;
    private int shopId;
    private int state;
    private String stateStr;

    public Notice() {
    }

    public Notice(int id, String title, String content, String picUrl, Date noticeTime, int shopId, int state, String stateStr) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.picUrl = picUrl;
        this.noticeTime = noticeTime;
        this.shopId = shopId;
        this.state = state;
        this.stateStr = stateStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }
}
