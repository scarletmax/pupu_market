package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.*;
import com.cykj.marketshop.mapper.CouponMapper;
import com.cykj.marketshop.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("couponService")
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponMapper couponMapper;

    @Override
    public List<String> findCouponState() {
        List<String> couponList = null;
        couponList = couponMapper.findCouponState();
        return couponList;
    }

    @Override
    public LayData findCouponList(HashMap<String, Object> condition) {
        LayData layuiData = new LayData();
        List<Coupon> couponList = couponMapper.findCouponList(condition);
        int count = couponMapper.findCouponCount(condition);
        if (couponList.size() > 0) {
            layuiData.setCode(0);
            layuiData.setMsg("");
            layuiData.setCount(count);
            layuiData.setData(couponList);
        } else {
            layuiData.setCode(1);
            layuiData.setMsg("加载失败");
        }
        return layuiData;
    }

    @Override
    public boolean updateState(int id,String state) {
        int result = 0;
        //更新审核状态
        result = couponMapper.updateState(id, state);
        return result > 0;
    }
    @Override
    public int addCouppon(Coupon coupon) {
        int a=0;
        a = couponMapper.addCouppon(coupon);
        return a;
    }
}
