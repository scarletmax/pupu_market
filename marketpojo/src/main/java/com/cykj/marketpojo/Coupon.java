package com.cykj.marketpojo;

import java.math.BigDecimal;
import java.util.Date;

public class Coupon {
    private int id;
    private String name;

    private Date startTime;
    private Date endTime;
    private int shopId;
    private BigDecimal favorPrice;
    private int limitCount;
    private BigDecimal requirePrice;
    private String rule;
    private String stateStr;
    private int state;

    public Coupon() {
    }

    public Coupon(int id, String name, Date startTime, Date endTime, int shopId, BigDecimal favorPrice, int limitCount, BigDecimal requirePrice, String rule, String stateStr) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shopId = shopId;
        this.favorPrice = favorPrice;
        this.limitCount = limitCount;
        this.requirePrice = requirePrice;
        this.rule = rule;
        this.stateStr = stateStr;
    }

    public Coupon(int id, String name, Date startTime, Date endTime, int shopId, BigDecimal favorPrice, int limitCount, BigDecimal requirePrice, String rule, String stateStr, int state) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shopId = shopId;
        this.favorPrice = favorPrice;
        this.limitCount = limitCount;
        this.requirePrice = requirePrice;
        this.rule = rule;
        this.stateStr = stateStr;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getFavorPrice() {
        return favorPrice;
    }

    public void setFavorPrice(BigDecimal favorPrice) {
        this.favorPrice = favorPrice;
    }

    public int getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(int limitCount) {
        this.limitCount = limitCount;
    }

    public BigDecimal getRequirePrice() {
        return requirePrice;
    }

    public void setRequirePrice(BigDecimal requirePrice) {
        this.requirePrice = requirePrice;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
