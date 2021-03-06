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

//    根据用户发送的商店ID获取对应的前6条特价商品
    @RequestMapping(value = "/getSpecialGood")
    @ResponseBody
    public String getSpecialGood(Integer shopId, HttpServletRequest request){
        List<Goods> goodsList = goodService.getSpecialGood(shopId);
        return JSON.toJSONString(goodsList);
    }
//    根据商店ID查询全部特价商品
    @RequestMapping(value = "/getMoreSpecialGood")
    @ResponseBody
    public String getMoreSpecialGood(Integer shopId, HttpServletRequest request){
        List<Goods> goodsList = goodService.getMoreSpecialGood(shopId);
        return JSON.toJSONString(goodsList);
    }
//    根据商店ID获取前六条销量最高的商品
    @RequestMapping(value = "/getHighSaleGood")
    @ResponseBody
    public String getHighSaleGood(Integer shopId,HttpServletRequest request){
        List<Goods> goodsList = goodService.getHighSaleGood(shopId);
        return JSON.toJSONString(goodsList);
    }
    //    根据商店ID获取掌柜推荐的商品
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

    @RequestMapping(value = "/findNewGoods")
    @ResponseBody
    public Object findNewGoods(int shopId){
        return JSON.toJSONString(goodService.findNewGoods(shopId));
    }
    @RequestMapping(value = "/findMoreNewGoods")
    @ResponseBody
    public Object findMoreNewGoods(int shopId){
        return JSON.toJSONString(goodService.findMoreNewGoods(shopId));
    }
}
