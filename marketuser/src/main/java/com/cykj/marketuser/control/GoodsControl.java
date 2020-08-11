package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketuser.service.GoodsService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("goodsControl")
@Controller
public class GoodsControl {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("getGoodsListByType")
    @ResponseBody
    public String getGoodsListByType(int shopId,int typeId) {
        return JSON.toJSONString(goodsService.getGoodsListByType(shopId,typeId));
    }
    @RequestMapping("queryGoodsDetail")
    @ResponseBody
    public String queryGoodsDetail(int id ) {
        return JSON.toJSONString(goodsService.queryGoodsDetail(id));
    }

 }
