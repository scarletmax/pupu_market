package com.cykj.marketshop.service;

import java.math.BigDecimal;
import java.util.HashMap;

public interface ShopStatisticsService {
    int totalInventory(HashMap<String,Object> hashMap); ////总库存
    int totalSales(HashMap<String,Object> hashMap); //总销量
    int totalOrder(HashMap<String,Object> hashMap);//总订单
    BigDecimal totalAmount(HashMap<String,Object> hashMap);//总营业额
}
