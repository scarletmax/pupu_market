package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.FlashSale;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.service.FlashSaleService;
import com.cykj.marketshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("flashSaleControl")
public class FlashSaleControl {

    @Autowired
    private FlashSaleService flashSaleService;


    @RequestMapping("/selectFlashSale")
    public String selectFlashSale(HttpServletRequest request, HttpServletResponse response){
        String curPage = request.getParameter("curPage");
        String pageSize = request.getParameter("pageSize");
        int shopId = ((ShopAdmin)(request.getSession().getAttribute("admin"))).getShopId();
        String goodsName = request.getParameter("goodsName");
        String containTime = request.getParameter("containTime");
        String state = request.getParameter("state");

        int curPage1 = Integer.parseInt(curPage);
        int pageSize1 = Integer.parseInt(pageSize);
        int offset1 = (curPage1-1)*pageSize1;

        HashMap<String,Object> condition = new HashMap<>();
        condition.put("offset",offset1);
        condition.put("pageSize",pageSize1);//name和shopid为可选搜索项，因此没点击搜索失为null或，点击时可能有数值或者为""
        condition.put("shopId",shopId);//mysql中的int和传上的string可以兼容
        condition.put("goodsName",goodsName);
        condition.put("containTime",containTime);
        condition.put("state",state);
        return JSON.toJSONString(flashSaleService.selectFlashSale(condition));
    }

    @RequestMapping("/insertFlashSale")
    public String insertFlashSale(FlashSale flashSale, HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(flashSaleService.insertFlashSale(flashSale)+"");
    }

}
