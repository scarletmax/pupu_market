package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.User;
import com.cykj.marketuser.mapper.LoginMapper;
import com.cykj.marketuser.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private  LoginMapper loginMapper;
    @Override
    public User weixinLogin(User user) {
        //先判断是否是第一次在本平台使用微信登录
        if(loginMapper.checkOpenid(user) == null) {
            loginMapper.insertWeixinUser(user);
            user=loginMapper.loginByWeixin(user);
        }else {
           user= loginMapper.loginByWeixin(user);
        }
        return user ;
    }

    @Override
    public User loginByTel(String  tel,String pwd) {
        User user=loginMapper.loginByTel(new User(tel,pwd));
        if(user==null) {
            user=new User();
            user.setId(0);
        }
        return  user;
    }
}
