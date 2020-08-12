package com.cykj.marketdelivery.service;

import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.User;

public interface UserService {
    public Deliveryman login(Deliveryman deliveryman);
    public Deliveryman getUserInfo(Integer id);
}
