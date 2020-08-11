package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Advertisement;
import com.cykj.marketuser.service.ShowAdvertismentService;
import com.cykj.marketuser.service.SpecialGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/showAdvertismentControl")
public class ShowAdvertismentControl {

    @Autowired
    private ShowAdvertismentService showAdvertismentService;

    //查找轮播图广告
    @RequestMapping(value = "/findCarouselAD")
    @ResponseBody
    public Object findCarouselAD(){
        List<Advertisement> list=showAdvertismentService.findCarouselAD();
        System.out.println("list="+JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }
    //查找静态广告
    @RequestMapping(value = "/findStaticAD")
    @ResponseBody
    public Object findStaticAD(){
        List<Advertisement> list=showAdvertismentService.findStaticAD();
        System.out.println("list="+JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }
}
