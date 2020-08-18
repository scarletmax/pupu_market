package com.cykj.marketpojo;

import java.math.BigDecimal;

public class ShopStatistics {

    private String totalInventory;//总库存
    private String totalSales; //总销量
    private int totalOrder; //总订单
    private String totalAmount;//总营业额

    public ShopStatistics(String totalInventory, String totalSales, int totalOrder, String totalAmount) {
        this.totalInventory = totalInventory;
        this.totalSales = totalSales;
        this.totalOrder = totalOrder;
        this.totalAmount = totalAmount;
    }

    public String getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(String totalInventory) {
        this.totalInventory = totalInventory;
    }

    public String getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ShopStatistics() {
        super();
    }
}
