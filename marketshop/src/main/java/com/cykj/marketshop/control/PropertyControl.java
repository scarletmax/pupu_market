package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketshop.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping(value = "/propertyControl")
public class PropertyControl {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/enumGoodsState")
    @ResponseBody
    public String enumGoodsState(){
        return JSON.toJSONString(propertyService.enumGoodsState());
    }

}
