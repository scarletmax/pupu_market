package com.cykj.marketshop.service.impl;

import com.cykj.marketshop.mapper.ShopStatisticsMapper;
import com.cykj.marketshop.service.ShopStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class ShopStatisticsServiceImpl implements ShopStatisticsService {

    @Autowired
    private ShopStatisticsMapper shopStatisticsMapper;

    @Override
    public int totalInventory(HashMap<String, Object> hashMap) {
        return shopStatisticsMapper.totalInventory(hashMap);
    }

    @Override
    public int totalSales(HashMap<String, Object> hashMap) {
        return shopStatisticsMapper.totalSales(hashMap);
    }

    @Override
    public int totalOrder(HashMap<String, Object> hashMap) {
        return shopStatisticsMapper.totalOrder(hashMap);
    }

    @Override
    public BigDecimal totalAmount(HashMap<String, Object> hashMap) {
        return shopStatisticsMapper.totalAmount(hashMap);
    }
}
