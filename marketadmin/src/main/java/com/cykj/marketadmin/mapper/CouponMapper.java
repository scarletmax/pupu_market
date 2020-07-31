package com.cykj.marketadmin.mapper;

import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.CouponUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CouponMapper {
    List<Coupon> findCoupon(HashMap<String, Object> hashMap);
    List<CouponUser> findCouponUser(HashMap<String, Object> hashMap);
}
