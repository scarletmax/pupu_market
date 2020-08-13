package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.ReceiverInfo;
import com.cykj.marketuser.pojo.OrderInfo;
import com.cykj.marketuser.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("orderControl")
public class OrderControl {
    @Autowired
    private OrderService orderService;
    @RequestMapping("getRelativeInfo")
    @ResponseBody
    public String getRelativeInfo(int userId){
        return JSON.toJSONString(orderService.getRelativeInfo(userId));
    }
    @ResponseBody
    @RequestMapping("createOrder")
    public String createOrder(int userId, int shopId, String receiverInfoStr,String goodsListStr,double totalPrice){
        JSONArray arrayList= JSONArray.parseArray(goodsListStr);
        //转换为目标对象list
        List<Goods> goodsList = JSONObject.parseArray(arrayList.toJSONString(), Goods.class);
        ReceiverInfo receiverInfo=JSON.parseObject(receiverInfoStr,ReceiverInfo.class);
        System.out.println("收件人信息"+receiverInfoStr);
        System.out.println("商品列表"+JSON.toJSONString(goodsList));
        return  orderService.createOrder(userId,shopId,receiverInfo,goodsList,totalPrice);
    }
}
