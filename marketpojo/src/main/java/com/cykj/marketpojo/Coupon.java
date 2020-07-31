package com.cykj.marketpojo;

import java.math.BigDecimal;
import java.util.Date;

public class Coupon {
    private int id;
    private String name;

    private Date start_Time;
    private Date end_Time;
    private int shop_id;
    private BigDecimal favor_price;
    private int limitCount;
    private BigDecimal requirePrice;
    private String rule;

    public Coupon(int id, String name, Date start_Time, Date end_Time, int shop_id, BigDecimal favor_price, int limitCount, BigDecimal requirePrice, String rule) {
        this.id = id;
        this.name = name;
        this.start_Time = start_Time;
        this.end_Time = end_Time;
        this.shop_id = shop_id;
        this.favor_price = favor_price;
        this.limitCount = limitCount;
        this.requirePrice = requirePrice;
        this.rule = rule;
    }

    public Coupon() {
        super();
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

    public Date getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(Date start_Time) {
        this.start_Time = start_Time;
    }

    public Date getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(Date end_Time) {
        this.end_Time = end_Time;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public BigDecimal getFavor_price() {
        return favor_price;
    }

    public void setFavor_price(BigDecimal favor_price) {
        this.favor_price = favor_price;
    }

    public int getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(int limitCount) {
        this.limitCount = limitCount;
    }

    public BigDecimal getRequirePrice() {
        return requirePrice;
    }

    public void setRequirePrice(BigDecimal requirePrice) {
        this.requirePrice = requirePrice;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
