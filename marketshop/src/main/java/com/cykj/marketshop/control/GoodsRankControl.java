package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;

import com.cykj.marketpojo.GoodsRank;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.service.GoodsRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("goodsRankControl")
public class GoodsRankControl {

    @Autowired
    private GoodsRankService goodsRankService;

    @RequestMapping("/findgoodsRank")
    @ResponseBody
    public String findgoodsRank(HttpServletRequest request){


        HashMap<String,Object> hashMap=new HashMap<>();
        HttpSession session = request.getSession();
        ShopAdmin shopAdmin = (ShopAdmin) session.getAttribute("admin");
        List<GoodsRank> list=null;
        if(shopAdmin.getShopId()!=0){
            hashMap.put("shopId",shopAdmin.getShopId());

            list =goodsRankService.findGoodsRank(hashMap);

        }



        return JSON.toJSONString(list);
    }
    @RequestMapping("/findgoodsRank2")
    @ResponseBody
    public String findgoodsRank2(HttpServletRequest request){

        HashMap<String,Object> hashMap=new HashMap<>();
        HttpSession session = request.getSession();
        ShopAdmin shopAdmin = (ShopAdmin) session.getAttribute("admin");
        List<GoodsRank> list=null;
        if(shopAdmin.getShopId()!=0) {
            hashMap.put("shopId", shopAdmin.getShopId());
            list =goodsRankService.findGoodsRank2(hashMap);
        }


        return JSON.toJSONString(list);
    }
}
