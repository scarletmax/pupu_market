package com.cykj.marketshop.service;

import com.cykj.marketpojo.Property;

import java.util.List;

public interface PropertyService {

    //枚举商品状态
    List<Property> enumGoodsState();
    //枚举秒杀状态
    List<Property> enumFlashSaleState();
}
