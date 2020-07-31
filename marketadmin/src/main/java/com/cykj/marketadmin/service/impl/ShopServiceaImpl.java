package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.ShopMapper;
import com.cykj.marketadmin.service.ShopService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Shop;
import com.cykj.marketpojo.ShopAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ShopServiceaImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;
    @Override
    public LayData<Shop> findShop(HashMap<String, Object> hashMap) {

        LayData<Shop> layData=new LayData<>();
        List<Shop> list=shopMapper.findShop(hashMap);
        int total=shopMapper.findShopCount(hashMap);
        layData.setData(list);
        layData.setCount(total);
        layData.setMsg("");
        return layData;

    }

    @Override
    public LayData<ShopAdmin> findShopAdmin(HashMap<String, Object> hashMap) {

        LayData<ShopAdmin> layData=new LayData<>();
        List<ShopAdmin> list=shopMapper.findShopAdmin(hashMap);
        int total=shopMapper.findShopAdminCount(hashMap);
        layData.setData(list);
        layData.setCount(total);
        layData.setMsg("");
        return layData;
    }

    @Override
    public int changeState(HashMap<String, Object> hashMap) {
        return shopMapper.changeState(hashMap);
    }
}
