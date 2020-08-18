package com.cykj.marketdelivery.service.impl;

import com.cykj.marketdelivery.mapper.RegisterMapper;
import com.cykj.marketdelivery.service.RegisterService;
import com.cykj.marketpojo.Deliveryman;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private RegisterMapper registerMapper;


    @Override
    public int register(Deliveryman deliveryman) {
        return registerMapper.register(deliveryman);
    }

    @Override
    public int isTelRepeat(String tel) {
        return registerMapper.isTelRepeat(tel);
    }
}
