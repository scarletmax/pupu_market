package com.cykj.marketshop.service;

import com.cykj.marketpojo.*;
import com.cykj.marketpojo.Coupon;

import java.util.HashMap;
import java.util.List;

public interface CouponService {
    public List<String> findCouponState();
    public LayData findCouponList(HashMap<String, Object> condition);
    public boolean updateState(int id, String state);
    public int addCouppon(Coupon coupon);
}
