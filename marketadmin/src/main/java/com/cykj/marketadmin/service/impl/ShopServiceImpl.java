package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.ShopMapper;
import com.cykj.marketadmin.service.ShopService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Property;
import com.cykj.marketpojo.Shop;
import com.cykj.marketpojo.ShopAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

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

    @Override
    public List<Shop> searchShop(){
        return shopMapper.selectShop();
    }

    @Override
    public int insertShopAdmin(HashMap<String, Object> hashMap) {
        return shopMapper.insertShopAdmin(hashMap);
    }

    @Override
    public List<Shop> shopList() {
        return shopMapper.shopList();
    }

    @Override
    public int changeShoopState(HashMap<String, Object> hashMap) {
        return shopMapper.changeShoopState(hashMap);
    }

    @Override
    public List<Property> findProperty(HashMap<String, Object> hashMap) {
        return shopMapper.findProperty(hashMap);
    }
}
