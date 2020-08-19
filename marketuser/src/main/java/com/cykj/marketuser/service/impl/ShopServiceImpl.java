package com.cykj.marketuser.service.impl;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Marker;
import com.cykj.marketpojo.Shop;
import com.cykj.marketuser.mapper.ShopMapper;
import com.cykj.marketuser.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Override
    public List<Marker> getAllShopMarkers() {
        return shopMapper.getAllShopMarkers();
    }

    @Override
    public List<Shop> getShops(String longitude, String latitude) {
        List<Shop> shops = shopMapper.getShops(longitude,latitude);
        System.out.println(JSON.toJSONString(shops));
        for (int i = 0; i <shops.size(); i++) {
            String distance= shops.get(i).getDistance();
            System.out.println(distance);
            shops.get(i).setIntDistance(distance.split("\\.")[0]);
        }
        return shops;
    }
}
