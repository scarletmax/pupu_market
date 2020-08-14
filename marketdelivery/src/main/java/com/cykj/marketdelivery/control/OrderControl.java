package com.cykj.marketdelivery.control;

import com.alibaba.fastjson.JSON;

import com.cykj.marketdelivery.service.OrderService;
import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderControl {


    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/orderlist")
    @ResponseBody
    public String orderlist(Integer state,Integer id,String deliverymanId,String userName,String userId,String deliverymanName,String shopName,String startTime,String receiptName ,String endTime,Integer limit,Integer page){

        System.out.println("orderlist="+" userName="+userName+" userId="+userId+"  deliverymanName="+deliverymanName+" shopName="+shopName+" startTime="+startTime+" endTime="+endTime+" limit="+limit+" page="+page);
        HashMap<String ,Object> hashMap=new HashMap<>();
        System.out.println("limit="+limit);
        System.out.println("state="+state);
        if (limit==null||limit== 0) {
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
        hashMap.put("id",id);
        hashMap.put("state",state);
        return JSON.toJSONString(orderService.findOrderList(hashMap));
    }
    @RequestMapping(value = "/deliverOrder")
    @ResponseBody
    public Object deliverOrder(String deliverymanId){

        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("deliverymanId",deliverymanId);
        List<OrderDetail>  list=new ArrayList<OrderDetail>();
       list= orderService.deliverOrder(hashMap);
        if(list!=null){
            Property property=orderService.findDelivermoney();
            for (OrderDetail orderDetail : list) {
                orderDetail.setBenefit(property.getValue());
            }
        }

        return JSON.toJSONString(list);
    }
    @RequestMapping(value = "/confirmReceipt")
    @ResponseBody
    public Object confirmReceipt(String id) {



        return null;
    }
}
