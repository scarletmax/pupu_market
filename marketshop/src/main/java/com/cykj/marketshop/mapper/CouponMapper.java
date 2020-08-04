package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CouponMapper {
    List<String> findCouponState();
    List<Coupon> findCouponList(HashMap<String, Object> condition);
    int  findCouponCount(HashMap<String, Object> condition);
    int updateState(int id, String state);
    int addCouppon(Coupon coupon);
}
