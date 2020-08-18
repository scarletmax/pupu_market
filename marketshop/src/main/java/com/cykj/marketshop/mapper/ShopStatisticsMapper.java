package com.cykj.marketshop.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.HashMap;

@Mapper
public interface ShopStatisticsMapper {

    String totalInventory(HashMap<String,Object> hashMap); ////总库存
    String totalSales(HashMap<String,Object> hashMap); //总销量
    int totalOrder(HashMap<String,Object> hashMap);//总订单
    String totalAmount(HashMap<String,Object> hashMap);//总营业额


}
