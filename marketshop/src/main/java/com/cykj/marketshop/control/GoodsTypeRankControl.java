package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.GoodsRank;
import com.cykj.marketpojo.GoodsTypeRank;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.service.GoodsTypeRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("goodsTypeRankControl")
public class GoodsTypeRankControl {

    @Autowired
    private GoodsTypeRankService goodsTypeRankService;

    @RequestMapping("/findGoodsTypeRank")
    @ResponseBody
    public Object findGoodsTypeRank(HttpServletRequest request){

        HashMap<String ,Object> hashMap=new HashMap<>();
        HttpSession session = request.getSession();
        ShopAdmin shopAdmin = (ShopAdmin) session.getAttribute("admin");

        List<GoodsTypeRank> list=null;
        if(shopAdmin.getShopId()!=0) {
            hashMap.put("shopId", shopAdmin.getShopId());
            list =goodsTypeRankService.findGoodsTypeRank(hashMap);
        }
        request.setAttribute("adminName",shopAdmin.getName());
        return JSON.toJSONString(list);
    }
}
