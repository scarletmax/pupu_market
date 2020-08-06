package com.cykj.marketpojo;

import java.math.BigDecimal;

public class ShopStatistics {

    private int totalInventory;//总库存
    private int totalSales; //总销量
    private int totalOrder; //总订单
    private BigDecimal totalAmount;//总营业额

    public ShopStatistics(int totalInventory, int totalSales, int totalOrder, BigDecimal totalAmount) {
        this.totalInventory = totalInventory;
        this.totalSales = totalSales;
        this.totalOrder = totalOrder;
        this.totalAmount = totalAmount;
    }

    public int getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(int totalInventory) {
        this.totalInventory = totalInventory;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ShopStatistics() {
        super();
    }
}
