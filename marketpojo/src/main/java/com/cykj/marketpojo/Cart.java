package com.cykj.marketpojo;

public class Cart {
    private int id;
    private int userId;
    private int goodsId;
    private String userName;
    private String goodsName;
    private int goodsCount;
    private String choiceProp;
    private int shopId;
    private String shopName;
    private String intro;
    private String pic1;
    private  int totalCount;
    private Double price;


    public Cart() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getIntro() {
        return intro;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Cart(int userId, int goodsId, int shopId) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.shopId = shopId;
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

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getChoiceProp() {
        return choiceProp;
    }

    public void setChoiceProp(String choiceProp) {
        this.choiceProp = choiceProp;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
