package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.ShopAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface LoginMapper {
    //管理员登录
    ShopAdmin login(ShopAdmin admin);
    ShopAdmin telLogin(String tel);
    //更改密码
    int changePwd(HashMap<String,Object> hashMap);
}
