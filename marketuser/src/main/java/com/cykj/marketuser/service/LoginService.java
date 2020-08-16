package com.cykj.marketuser.service;

import com.cykj.marketpojo.User;

public interface LoginService {
    User weixinLogin(User user);
    User loginByTel(String  tel,String pwd);
}
