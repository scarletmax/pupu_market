package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.Shop;
import com.cykj.marketpojo.ShopAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ShopMapper {
    List<Shop> findShop(HashMap<String, Object> hashMap);
    int findShopCount(HashMap<String, Object> hashMap);

    List<ShopAdmin> findShopAdmin(HashMap<String, Object> hashMap);
    int findShopAdminCount(HashMap<String, Object> hashMap);

    int changeState(HashMap<String, Object> hashMap);

    List<Shop> selectShop();
    int insertShopAdmin(HashMap<String, Object> hashMap);
    List<Shop> shopList();

    int changeShoopState(HashMap<String, Object> hashMap);
    List<Property> findProperty(HashMap<String, Object> hashMap);
}
