package com.cykj.marketpojo;

import java.util.Date;

public class FlashSale {

    private int id;
    private int goodsId;
    private int goodsName;
    private Date startTime;
    private Date endTime;
    private int restCount;
    private int limitBuy;
    private double flashPrice;
    private int version;
    private Date createTime;
    private int state;
    private String stateStr;

    public FlashSale() {
    }

    public int getId() {
        return id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getRestCount() {
        return restCount;
    }

    public int getLimitBuy() {
        return limitBuy;
    }

    public double getFlashPrice() {
        return flashPrice;
    }

    public int getVersion() {
        return version;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setRestCount(int restCount) {
        this.restCount = restCount;
    }

    public void setLimitBuy(int limitBuy) {
        this.limitBuy = limitBuy;
    }

    public void setFlashPrice(double flashPrice) {
        this.flashPrice = flashPrice;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public int getState() {
        return state;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public int getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(int goodsName) {
        this.goodsName = goodsName;
    }
}
