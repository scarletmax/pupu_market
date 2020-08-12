package com.cykj.marketpojo;

import java.math.BigDecimal;
import java.util.Date;

public class DeliverymanFund {
    private int id;
    private int deliverymanId;
    private BigDecimal income;
    private Date createTime;
    private int orderDetailId;
    private int type;

    public DeliverymanFund(int id, int deliverymanId, BigDecimal income, Date createTime, int orderDetailId, int type) {
        this.id = id;
        this.deliverymanId = deliverymanId;
        this.income = income;
        this.createTime = createTime;
        this.orderDetailId = orderDetailId;
        this.type = type;
    }

    public DeliverymanFund() {
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

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
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
