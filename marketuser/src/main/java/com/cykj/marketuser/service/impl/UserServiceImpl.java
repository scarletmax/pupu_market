package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.User;
import com.cykj.marketuser.mapper.UserMapper;
import com.cykj.marketuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(Integer id) {
        return userMapper.getUserInfo(id);
    }
}
