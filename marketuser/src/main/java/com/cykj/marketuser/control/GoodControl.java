package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketuser.service.GoodService;
import com.cykj.marketuser.service.SpecialGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cykj.marketpojo.Goods;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("goodControl")
public class GoodControl {
    @Autowired
    private GoodService goodService;
    @Autowired
    private SpecialGoodsService specialGoodsService;

    @RequestMapping(value = "/getSpecialGood")
    @ResponseBody
    public String getSpecialGood(Integer shopId, HttpServletRequest request){
        List<Goods> goodsList = goodService.getSpecialGood(shopId);
        return JSON.toJSONString(goodsList);
    }

    @RequestMapping(value = "/getHighSaleGood")
    @ResponseBody
    public String getHighSaleGood(Integer shopId,HttpServletRequest request){
        List<Goods> goodsList = goodService.getHighSaleGood(shopId);
        return JSON.toJSONString(goodsList);
    }

    @RequestMapping(value = "/getRecommendedGood")
    @ResponseBody
    public String getRecommendedGood(Integer shopId,HttpServletRequest request){
        List<Goods> goodsList = goodService.getRecommendedGood(shopId);
        return JSON.toJSONString(goodsList);
    }
    @RequestMapping(value = "/findSpecialGoods")
    @ResponseBody
    public Object findSpecialGoods(){
        return JSON.toJSONString(specialGoodsService.findSpecialGoods());
    }

}
