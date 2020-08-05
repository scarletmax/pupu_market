package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping("goodsControl")
public class GoodsControl {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/searchGoodsList")
    public String searchGoodsList(HttpServletRequest request, HttpServletResponse response){
        String curPage = request.getParameter("curPage");
        String pageSize = request.getParameter("pageSize");
        //int shopId = ((ShopAdmin)(request.getSession().getAttribute("shopAdmin"))).getShopId();
        String name = request.getParameter("name");
        String typeId = request.getParameter("typeId");
        String parentTypeId = request.getParameter("parentTypeId");
        String price_min = request.getParameter("price_min");
        String price_max = request.getParameter("price_max");
        String state = request.getParameter("state");


        int curPage1 = Integer.parseInt(curPage);
        int pageSize1 = Integer.parseInt(pageSize);
        int offset1 = (curPage1-1)*pageSize1;

        HashMap<String,Object> condition = new HashMap<>();
        condition.put("offset",offset1);
        condition.put("pageSize",pageSize1);//name和shopid为可选搜索项，因此没点击搜索失为null或，点击时可能有数值或者为""
//        condition.put("shopId",shopId);//mysql中的int和传上的string可以兼容
        condition.put("name",name);
        condition.put("typeId",typeId);
        condition.put("parentTypeId",parentTypeId);
        condition.put("price_min",price_min);
        condition.put("price_max",price_max);
        condition.put("state",state);
        return JSON.toJSONString(goodsService.searchGoodsList(condition));
    }

    @RequestMapping("/startRecommended")
    public String startRecommended(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.startRecommended(id)+"");
    }

    @RequestMapping("/endRecommended")
    public String endRecommended(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.endRecommended(id)+"");
    }

    @RequestMapping("/startSpecial")
    public String startSpecial(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.startSpecial(id)+"");
    }

    @RequestMapping("/endSpecial")
    public String endSpecial(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.endSpecial(id)+"");
    }

    @RequestMapping("/putaway")
    public String putaway(int[] idArr,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.putaway(idArr)+"");
    }

    @RequestMapping("/unshelve")
    public String unshelve(int[] idArr,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.unshelve(idArr)+"");
    }

    @RequestMapping("/deleteGoods")
    public String deleteGoods(int[] idArr,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(goodsService.deleteGoods(idArr)+"");
    }

}
