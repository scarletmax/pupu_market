package com.cykj.marketuser.service;

import com.cykj.marketuser.mapper.CouponMapper;

import java.util.List;

public interface CouponService {

    public List<CouponMapper> selectCouponList(int userId);
}
