package com.cykj.marketadmin.service;



import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.CouponUser;

import java.util.HashMap;
import java.util.List;

public interface CouponService {

    List<Coupon> findCoupon(HashMap<String, Object> hashMap);
    List<CouponUser> findCouponUser(HashMap<String, Object> hashMap);
}
