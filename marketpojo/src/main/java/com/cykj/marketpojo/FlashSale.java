package com.cykj.marketpojo;

import java.util.Date;

public class FlashSale {

    private int id;
    private int goodsId;
    private Date startTime;
    private Date endTime;
    private int saleLimit;
    private int saleCount;
    private double salePrice;
    private int version;

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

    public int getSaleLimit() {
        return saleLimit;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public double getSalePrice() {
        return salePrice;
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

    public void setSaleLimit(int saleLimit) {
        this.saleLimit = saleLimit;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
