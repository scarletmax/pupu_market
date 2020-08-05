package com.cykj.marketshop.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.HashMap;

@Mapper
public interface ShopStatisticsMapper {

    int totalInventory(HashMap<String,Object> hashMap); ////总库存
    int totalSales(HashMap<String,Object> hashMap); //总销量
    int totalOrder(HashMap<String,Object> hashMap);//总订单
    BigDecimal totalAmount(HashMap<String,Object> hashMap);//总营业额


}
