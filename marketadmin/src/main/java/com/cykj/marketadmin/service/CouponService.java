package com.cykj.marketadmin.service;



import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.CouponUser;

import java.util.HashMap;
import java.util.List;

public interface CouponService {
//优惠券列表
    List<Coupon> findCoupon(HashMap<String, Object> hashMap);
    //优惠券使用者
    List<CouponUser> findCouponUser(HashMap<String, Object> hashMap);
}
