package com.cykj.marketpojo;

import java.util.Date;

public class DeliverymanComment {
    private int id;
    private int deliverymanId;
    private int point;
    private String comment;
    private Date createTime;
    private int userId;
    private int orderDetailId;

    public DeliverymanComment(int id, int deliverymanId, int point, String comment, Date createTime, int userId, int orderDetailId) {
        this.id = id;
        this.deliverymanId = deliverymanId;
        this.point = point;
        this.comment = comment;
        this.createTime = createTime;
        this.userId = userId;
        this.orderDetailId = orderDetailId;
    }

    public DeliverymanComment() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(int deliverymanId) {
        this.deliverymanId = deliverymanId;
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
