package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketuser.service.CouponService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("couponControl")
public class CouponControl {

    @Resource
    private CouponService couponService;

    @RequestMapping(value = "/selectCouponList")
    @ResponseBody
    public String selectCouponList(int userId){
        userId = 1;
        return JSON.toJSONString(couponService.selectCouponList(userId));
    }


}
