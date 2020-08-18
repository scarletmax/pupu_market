package com.cykj.marketpojo;

import java.util.List;

public class Goods {

    private int id;
    private String name;
    private String intro;
    private String pic1;
    private String pic2;
    private String pic3;
    private  String pic4;
    private int recommended;
    private int special;
    private int totalCount;//剩余总数 库存
    private Double price;
    private Double specialPrice;
    private  int parentTypeId;
    private String parentTypeString;
    private int typeId;
    private  String typeString;
    private int flashSale;
    private int state;
    private String stateStr;
    private String infoPic;
    private int shopId;
    private String shopName;
    private String choiceProp1;
    private String choiceProp2;
    private String choiceProp3;
    private Album album;
    private List<String>  imgList;
    private int saleCount;//销量
    private int commentCount;
    private GoodsComment goodsComment;
    private  String createTimeStr;
    //为了配合前端 订单部分
    private int goodsId;
    private String goodsName;
    private int goodsCount;//购买个数
    //新增订单时插入商品
    private int orderDetailId;
    private String choiceProp;
    private int version;
    private int userId;
    private double totalPrice;

    public String getChoiceProp() {
        return choiceProp;
    }

    public void setChoiceProp(String choiceProp) {
        this.choiceProp = choiceProp;
    }

    public Goods() {
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getVersion() {
        return version;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public String getPic4() {
        return pic4;
    }

    public void setPic4(String pic4) {
        this.pic4 = pic4;
    }

    public int getRecommended() {
        return recommended;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public int getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(int parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    public String getParentTypeString() {
        return parentTypeString;
    }

    public void setParentTypeString(String parentTypeString) {
        this.parentTypeString = parentTypeString;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public int getFlashSale() {
        return flashSale;
    }

    public void setFlashSale(int flashSale) {
        this.flashSale = flashSale;
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

    public String getInfoPic() {
        return infoPic;
    }

    public void setInfoPic(String infoPic) {
        this.infoPic = infoPic;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getChoiceProp1() {
        return choiceProp1;
    }

    public void setChoiceProp1(String choiceProp1) {
        this.choiceProp1 = choiceProp1;
    }

    public String getChoiceProp2() {
        return choiceProp2;
    }

    public void setChoiceProp2(String choiceProp2) {
        this.choiceProp2 = choiceProp2;
    }

    public String getChoiceProp3() {
        return choiceProp3;
    }

    public void setChoiceProp3(String choiceProp3) {
        this.choiceProp3 = choiceProp3;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public GoodsComment getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(GoodsComment goodsComment) {
        this.goodsComment = goodsComment;
    }
}
