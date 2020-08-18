package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;

import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "couponControl")
public class CouponControl {

    @Autowired
    private CouponService couponService;

    @RequestMapping(value = "findCouponUser")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public Object findCouponUser(int id){
        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("id",id);
        System.out.println("findCouponUser");
        return JSON.toJSONString(couponService.findCouponUser(hashMap));
    }
}
