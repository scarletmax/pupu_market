package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.Shop;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.mapper.LoginMapper;
import com.cykj.marketshop.mapper.RegisMapper;
import com.cykj.marketshop.service.RegisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisServiceImpl implements RegisService {

    @Autowired
    private RegisMapper regisMapper;
    @Override
    public int verifyName(String name) {

        return regisMapper.verifyName(name);
    }

    @Override
    @Transactional/*实现事务操作*/
    public String insertShop(Shop shop) {

        int a=regisMapper.insertShop(shop);
        if(a>0){

            ShopAdmin shopAdmin=new ShopAdmin();
            shopAdmin.setPwd(shop.getPwd());
            shopAdmin.setShopId(shop.getId());
            shopAdmin.setAccount(shop.getTel());
            shopAdmin.setName(shop.getBossName());
            shopAdmin.setTel(shop.getTel());
            int b=regisMapper.insertShopAdmin(shopAdmin);
            return "success";

        }else {
            return "fail";
        }

    }

    @Override
    public int verifyTel(String tel) {
        return regisMapper.verifyTel(tel);
    }

    @Override
    @Transactional/*实现事务操作*/
    public int insertShopAdmin(ShopAdmin shopAdmin) {
        return regisMapper.insertShopAdmin(shopAdmin);
    }
}
