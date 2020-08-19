package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketuser.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("shop")
public class ShopControl {
    @Autowired
    private ShopService shopService;
    @ResponseBody
    @RequestMapping("getShops")
    public String getShops(String longitude,String latitude){
        return JSON.toJSONString(shopService.getShops(longitude,latitude) );
    }
    @ResponseBody
    @RequestMapping("getAllShopMarkers")
    public String getAllShopMarkers(){
        return JSON.toJSONString(shopService.getAllShopMarkers());
    }

}
