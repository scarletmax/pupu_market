package com.cykj.marketdelivery.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketdelivery.service.GetOrderService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("getOrder")
public class GetOrderControl {
    @Autowired
    private GetOrderService getOrderService;
    @ResponseBody
    @RequestMapping("showAvailOrder")
    public String showAvailOrder() {
        return JSON.toJSONString(getOrderService.showAvailOrder());
    }
    @ResponseBody
    @RequestMapping("getAllShopMarkers")
    public String getAllShopMarkers(){
        return JSON.toJSONString(getOrderService.getAllShopMarkers());
    }
    @ResponseBody
    @RequestMapping("getOrder")
    public String getOrder(int deliverymanId,int id){
        return JSON.toJSONString(getOrderService.getOrder(deliverymanId,id));
    }
    @ResponseBody
    @RequestMapping("showCurOrders")
    public String  showCurOrders(int deliverymanId){
        return JSON.toJSONString(getOrderService.showCurOrders(deliverymanId));
    }
    @ResponseBody
    @RequestMapping("getRouteMsg")
    public String getRouteMsg(int id,double longitude,double latitude ){
        String res=JSON.toJSONString(getOrderService.getRouteMsg(id,longitude,latitude));
        System.out.println(res);
//        return JSON.toJSONString(getOrderService.getRouteMsg(id,longitude,latitude));
        return  res;
    }
    @ResponseBody
    @RequestMapping("arriveShop")
    public String arriveShop(int id){
        return JSON.toJSONString(getOrderService.arriveShop(id));
    }
    @ResponseBody
    @RequestMapping("arriveCustomer")
    public String arriveCustomer(int id){
        return JSON.toJSONString(getOrderService.arriveCustomer(id));
    }

}
