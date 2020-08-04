package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.Shop;
import com.cykj.marketpojo.ShopAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisMapper {

    int verifyName(String name);//验证店铺
    int insertShop(Shop shop); //创建店铺
    int verifyTel(String tel); //验证手机
    int insertShopAdmin(ShopAdmin shopAdmin);//注册商店管理员
}
