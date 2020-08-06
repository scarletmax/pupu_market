package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.mapper.LoginMapper;
import com.cykj.marketshop.service.LoginService;
import com.cykj.marketshop.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public ShopAdmin login(ShopAdmin userAdmin) {
        String pwd = userAdmin.getPwd();
        userAdmin.setPwd(MD5Util.md5(pwd));
        System.out.println("转换后：" + userAdmin.getAccount() + userAdmin.getPwd());
        ShopAdmin admin = null;
        admin = loginMapper.login(userAdmin);
        return admin;
    }

    @Override
    public ShopAdmin telLogin(String tel) {

        return loginMapper.telLogin(tel);
    }

    @Override
    public int changePwd(HashMap<String, Object> hashMap) {
        return loginMapper.changePwd(hashMap);
    }

}
