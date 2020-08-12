package com.cykj.marketuser.pojo;

import com.cykj.marketpojo.Goods;

import java.util.List;

public class OrderInfo {
    private int userId;
    private int shopId;
    private String receiverInfoStr;
    private List<Goods> goodsList;

    public OrderInfo(int userId, int shopId,  String receiverInfoStr, List<Goods> goodsList) {
        this.userId = userId;
        this.shopId = shopId;
        this.receiverInfoStr = receiverInfoStr;
        this.goodsList = goodsList;
    }

    public OrderInfo() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getReceiverInfoStr() {
        return receiverInfoStr;
    }

    public void setReceiverInfoStr(String receiverInfoStr) {
        this.receiverInfoStr = receiverInfoStr;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
