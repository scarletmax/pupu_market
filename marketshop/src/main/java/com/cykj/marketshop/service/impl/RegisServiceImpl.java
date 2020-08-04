package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.Shop;
import com.cykj.marketshop.mapper.LoginMapper;
import com.cykj.marketshop.mapper.RegisMapper;
import com.cykj.marketshop.service.RegisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisServiceImpl implements RegisService {

    @Autowired
    private RegisMapper regisMapper;
    @Override
    public int verifyName(String name) {

        return regisMapper.verifyName(name);
    }

    @Override
    public int insertShop(Shop shop) {
        return regisMapper.insertShop(shop);
    }
}
