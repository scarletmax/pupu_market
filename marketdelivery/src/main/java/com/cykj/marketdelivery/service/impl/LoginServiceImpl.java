package com.cykj.marketdelivery.service.impl;

import com.cykj.marketdelivery.mapper.LoginMapper;
import com.cykj.marketdelivery.service.LoginService;
import com.cykj.marketpojo.Deliveryman;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    LoginMapper loginMapper;


}
