package com.cykj.marketuser.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper {

    public List<CouponMapper> selectCouponList(int userId);
}
