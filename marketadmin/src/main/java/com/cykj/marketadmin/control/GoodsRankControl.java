package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.GoodsRankService;
import com.cykj.marketadmin.service.GoodsService;
import com.cykj.marketpojo.GoodsRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("goodsRankControl")
public class GoodsRankControl {

    @Autowired
    private GoodsRankService goodsRankService;

    @RequestMapping("/findgoodsRank")
    @ResponseBody
    public String findgoodsRank(){

        HashMap<String,Object> hashMap=new HashMap<>();

        List<GoodsRank> list =goodsRankService.findGoodsRank(hashMap);

        System.out.println("findgoodsRank===="+list);
        return JSON.toJSONString(list);
    }
    @RequestMapping("/findgoodsRank2")
    @ResponseBody
    public String findgoodsRank2(){

        HashMap<String,Object> hashMap=new HashMap<>();

        List<GoodsRank> list =goodsRankService.findGoodsRank2(hashMap);

        System.out.println("findgoodsRank===="+list);
        return JSON.toJSONString(list);
    }
}
