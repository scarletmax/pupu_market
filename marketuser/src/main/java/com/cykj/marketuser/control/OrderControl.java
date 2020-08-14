package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketuser.service.CouponService;
import com.cykj.marketuser.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("orderControl")
public class OrderControl {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/selectOrderAndGoods")
    @ResponseBody
    public String selectOrderAndGoods(int userId){
        return JSON.toJSONString(orderService.selectOrderAndGoods(userId));
    }


}
