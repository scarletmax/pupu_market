package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
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

    @RequestMapping("/showFlashByGoodsId")
    public String showFlashByGoodsId(String id,HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(flashSaleService.showFlashByGoodsId(id));
    }

}
