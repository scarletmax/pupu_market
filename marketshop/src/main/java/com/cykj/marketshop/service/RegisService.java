package com.cykj.marketshop.service;

import com.cykj.marketpojo.Shop;

public interface RegisService {
    int verifyName(String name);
    int insertShop(Shop shop);
}
