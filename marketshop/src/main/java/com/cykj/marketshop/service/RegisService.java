package com.cykj.marketshop.service;

import com.cykj.marketpojo.Shop;
import com.cykj.marketpojo.ShopAdmin;

public interface RegisService {
    int verifyName(String name);
    String insertShop(Shop shop);
    int verifyTel(String tel);
    int insertShopAdmin(ShopAdmin shopAdmin);//注册商店管理员


}
