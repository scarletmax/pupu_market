package com.cykj.marketadmin.service;



import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Shop;
import com.cykj.marketpojo.ShopAdmin;

import java.util.HashMap;
import java.util.List;

public interface ShopService {
    LayData<Shop> findShop(HashMap<String, Object> hashMap);
    LayData<ShopAdmin> findShopAdmin(HashMap<String, Object> hashMap);
    int changeState(HashMap<String, Object> hashMap);
    List<Shop> searchShop();
}
