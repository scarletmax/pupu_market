package com.cykj.marketshop.service;

import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.CouponUser;
import com.cykj.marketpojo.LayData;

import java.util.HashMap;
import java.util.List;

public interface CouponService {
    public List<String> findCouponState();
    public LayData findCouponList(HashMap<String, Object> condition);
    public boolean updateState(int id, String state);
    public int addCouppon(Coupon coupon);
    //优惠券列表
    List<Coupon> findCoupon(HashMap<String, Object> hashMap);
    //优惠券使用者
    List<CouponUser> findCouponUser(HashMap<String, Object> hashMap);

}
