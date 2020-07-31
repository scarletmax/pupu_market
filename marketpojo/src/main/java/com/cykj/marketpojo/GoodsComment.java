package com.cykj.marketpojo;

import java.util.Date;

public class GoodsComment {

    private int id;
    private int goodsId;
    private int point;
    private String comment;
    private Date createTime;
    private int userId;
    private int orderDetailId;
    private String goodsName;

    public GoodsComment(int id, int goodsId, int point, String comment, Date createTime, int userId, int orderDetailId, String goodsName) {
        this.id = id;
        this.goodsId = goodsId;
        this.point = point;
        this.comment = comment;
        this.createTime = createTime;
        this.userId = userId;
        this.orderDetailId = orderDetailId;
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public GoodsComment() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
}
