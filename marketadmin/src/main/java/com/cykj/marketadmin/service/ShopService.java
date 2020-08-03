package com.cykj.marketadmin.service;



import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Property;
import com.cykj.marketpojo.Shop;
import com.cykj.marketpojo.ShopAdmin;

import java.util.HashMap;
import java.util.List;

public interface ShopService {
    //分店列表
    LayData<Shop> findShop(HashMap<String, Object> hashMap);
    //分店管理员列表
    LayData<ShopAdmin> findShopAdmin(HashMap<String, Object> hashMap);
    //分店总数
    int changeState(HashMap<String, Object> hashMap);
    //分店管理员总数
    int insertShopAdmin(HashMap<String, Object> hashMap);
    //分店店名集合
    List<Shop> shopList();
     //修改分店状态
    int changeShoopState(HashMap<String, Object> hashMap);
    //参数集合
    List<Property> findProperty(HashMap<String, Object> hashMap);
}
