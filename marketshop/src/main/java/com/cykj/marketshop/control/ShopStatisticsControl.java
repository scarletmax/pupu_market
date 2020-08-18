package com.cykj.marketshop.control;


import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketpojo.ShopStatistics;
import com.cykj.marketshop.service.ShopStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;

@Controller
@RequestMapping("/shopStatisticsControl")
public class ShopStatisticsControl {

    @Autowired
    private ShopStatisticsService shopStatisticsService;

    @RequestMapping("/shopStatistics")
    @ResponseBody
    public Object shopStatistics(HttpServletRequest request){

        HashMap<String ,Object> hashMap=new HashMap<>();
        HttpSession session = request.getSession();
        ShopAdmin shopAdmin = (ShopAdmin) session.getAttribute("admin");
        ShopStatistics shopStatistics=new ShopStatistics();
        if(shopAdmin.getShopId()!=0) {
            hashMap.put("shopId", shopAdmin.getShopId());

            String a=shopStatisticsService.totalAmount(hashMap);
            String b=shopStatisticsService.totalInventory(hashMap);
            int c=shopStatisticsService.totalOrder(hashMap);
            String d=shopStatisticsService.totalSales(hashMap);
            shopStatistics.setTotalAmount(a);
            shopStatistics.setTotalInventory(b);
            shopStatistics.setTotalOrder(c);
            shopStatistics.setTotalSales(d);

        }
        System.out.println("shopStatistics="+JSON.toJSONString(shopStatistics));
        return JSON.toJSONString(shopStatistics);
    }
}
