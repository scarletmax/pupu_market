package com.cykj.marketpojo;

public class GoodsRank {
    private int id;//订单号
    private int GoodsId;//商品id
    private String name;//商品名
    private int co;//订单总数
    private String goodsName;//商品名
    private int goodsCount;//商品数
    private int tatol;//总数

    public GoodsRank() {

    }

    public GoodsRank(int id, int goodsId, String name, int co, String goodsName, int goodsCount, int tatol) {
        this.id = id;
        GoodsId = goodsId;
        this.name = name;
        this.co = co;
        this.goodsName = goodsName;
        this.goodsCount = goodsCount;
        this.tatol = tatol;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {

        this.goodsCount = goodsCount;
    }

    public int getTatol() {
        return goodsCount*co;//计算总数
    }

    public void setTatol(int tatol) {
        this.tatol = tatol;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(int goodsId) {
        GoodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }
}
