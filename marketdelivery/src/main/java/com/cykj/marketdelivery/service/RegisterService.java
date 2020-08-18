package com.cykj.marketdelivery.service;

import com.cykj.marketpojo.Deliveryman;


public interface RegisterService {

    public int register(Deliveryman deliveryman);
    public int isTelRepeat(String tel);
}
