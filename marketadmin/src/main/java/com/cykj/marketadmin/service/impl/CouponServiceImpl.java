package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.CouponMapper;
import com.cykj.marketadmin.service.CouponService;
import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.CouponUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;
    @Override
    public List<Coupon> findCoupon(HashMap<String, Object> hashMap) {

        return couponMapper.findCoupon(hashMap);
    }

    @Override
    public List<CouponUser> findCouponUser(HashMap<String, Object> hashMap) {
        return couponMapper.findCouponUser(hashMap);
    }
}
