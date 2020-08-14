package com.cykj.marketdelivery.service;

import com.cykj.marketpojo.Deliveryman;

public interface LoginService {

    //注册，账号重复抛出异常
    public int register(Deliveryman deliveryman) throws Exception;
}
