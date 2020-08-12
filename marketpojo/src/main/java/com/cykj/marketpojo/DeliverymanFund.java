package com.cykj.marketpojo;

import java.util.Date;

public class DeliverymanFund {
    private int id;
    private int deliverymanId;
    private double income;
    private Date createTime;
    private int orderDetailId;
    private int type;

    public DeliverymanFund() {
    }

    public DeliverymanFund(int id, int deliverymanId, double income, Date createTime, int orderDetailId, int type) {
        this.id = id;
        this.deliverymanId = deliverymanId;
        this.income = income;
        this.createTime = createTime;
        this.orderDetailId = orderDetailId;
        this.type = type;
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

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
