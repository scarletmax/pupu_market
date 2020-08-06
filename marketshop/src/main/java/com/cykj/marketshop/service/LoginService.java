package com.cykj.marketshop.service;

import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.ShopAdmin;

import java.util.HashMap;

public interface LoginService {
    //店铺管理员登陆
    ShopAdmin login(ShopAdmin admin);
    ShopAdmin telLogin(String tel);
    //更改密码
    int changePwd(HashMap<String,Object> hashMap);
}


