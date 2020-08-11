package com.cykj.marketuser.service.impl;

import com.cykj.marketuser.mapper.CouponMapper;
import com.cykj.marketuser.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("couponService")
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponMapper couponMapper;
    @Override
    public List<CouponMapper> selectCouponList(int userId) {
        return couponMapper.selectCouponList(userId);
    }
}
