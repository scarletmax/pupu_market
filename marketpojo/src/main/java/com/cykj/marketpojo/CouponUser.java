package com.cykj.marketpojo;

import java.util.Date;

public class CouponUser {
    private int id;
    private int userId;
    private int couponId;
    private Date createTime;
    private int state;
    private String couponName;
    private String stateStr;

    public CouponUser(int id, int userId, int couponId, Date createTime, int state, String couponName, String stateStr) {
        this.id = id;
        this.userId = userId;
        this.couponId = couponId;
        this.createTime = createTime;
        this.state = state;
        this.couponName = couponName;
        this.stateStr = stateStr;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public CouponUser() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
