package com.cykj.marketdelivery.control;

import com.alibaba.fastjson.JSON;

import com.cykj.marketdelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/order")
public class OrderControl {


    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/orderlist")
    @ResponseBody
    public String orderlist(String deliverymanId,String userName,String userId,String deliverymanName,String shopName,String startTime,String receiptName ,String endTime,int limit,int page){

        System.out.println("orderlist="+" userName="+userName+" userId="+userId+"  deliverymanName="+deliverymanName+" shopName="+shopName+" startTime="+startTime+" endTime="+endTime+" limit="+limit+" page="+page);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if (limit== 0) {
            limit=10;
        }
        if (page != 0) {

            page = (page - 1) * limit;
        } else {
            page = 0;
        }
        System.out.println(page);
        hashMap.put("page", page);
        hashMap.put("limit", limit);
        hashMap.put("userName",userName);
        hashMap.put("userId",userId);
        hashMap.put("deliverymanName",deliverymanName);
        hashMap.put("deliverymanId",deliverymanId);
        hashMap.put("startTime",startTime);
        hashMap.put("endTime",endTime);
        hashMap.put("shopName",shopName);
        hashMap.put("receiptName",receiptName);
        return JSON.toJSONString(orderService.findOrderList(hashMap));
    }

}
