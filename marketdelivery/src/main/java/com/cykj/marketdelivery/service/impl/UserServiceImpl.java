package com.cykj.marketdelivery.service.impl;

import com.cykj.marketdelivery.mapper.User1Mapper;
import com.cykj.marketdelivery.service.UserService;
import com.cykj.marketpojo.Deliveryman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private User1Mapper userMapper;

    @Override
    public Deliveryman login(Deliveryman deliveryman) {
        return userMapper.login(deliveryman);
    }

    @Override
    public Deliveryman getUserInfo(Integer id) {
        return userMapper.getUserInfo(id);
    }
}
