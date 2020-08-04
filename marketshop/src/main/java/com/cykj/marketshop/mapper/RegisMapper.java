package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.Shop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisMapper {

    int verifyName(String name);
    int insertShop(Shop shop);
}
