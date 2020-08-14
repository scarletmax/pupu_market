package com.cykj.marketpojo;

public class OrderGoodsHis {

    private int id;
    private int goodsId;//用于必要时候的关联，其余项都是历史
    private String GoodsName;
    private int goodsCount;
    private String choiceProp;
    private Double price;
    private String pic1;

    public OrderGoodsHis() {
    }

    public int getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public String getChoiceProp() {
        return choiceProp;
    }

    public Double getPrice() {
        return price;
    }

    public String getPic1() {
        return pic1;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public void setChoiceProp(String choiceProp) {
        this.choiceProp = choiceProp;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
