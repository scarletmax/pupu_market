package com.cykj.marketdelivery.control;

import com.alibaba.fastjson.JSON;


import com.cykj.marketdelivery.service.DeliverymanCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "CommentControl")
public class CommentControl {

//    @Autowired
//    private GoodsCommentService goodsCommentService;
    @Autowired
    private DeliverymanCommentService deliverymanCommentService;

//    @RequestMapping(value = "findGoodsComment")
//    @ResponseBody
//    public Object findGoodsComment(int id){
//
//        HashMap<String ,Object> hashMap=new HashMap<>();
//                hashMap.put("id",id);
//
//        return JSON.toJSONString(goodsCommentService.findGoodsComment(hashMap));
//    }
    @RequestMapping(value = "findDeliverymanComment")
    @ResponseBody
    public Object findDeliverymanComment(int id){

        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("id",id);

        return JSON.toJSONString(deliverymanCommentService.findDeliverymanComment(hashMap));
    }

}
