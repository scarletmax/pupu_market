package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("goodsControl")
public class GoodsControl {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/searchGoodsList")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String searchGoodsList(HttpServletRequest request, HttpServletResponse response){
        String curPage = request.getParameter("curPage");
        String pageSize = request.getParameter("pageSize");
        String name = request.getParameter("name");
        String shopId = request.getParameter("shopId");
        int curPage1 = Integer.parseInt(curPage);
        int pageSize1 = Integer.parseInt(pageSize);
        int offset1 = (curPage1-1)*pageSize1;

        HashMap<String,Object> condition = new HashMap<>();
        condition.put("offset",offset1);
        condition.put("pageSize",pageSize1);//name和shopid为可选搜索项，因此没点击搜索失为null或，点击时可能有数值或者为""
        condition.put("name",name);
        condition.put("shopId",shopId);//mysql中的int和传上的string可以兼容
        return JSON.toJSONString(goodsService.searchGoodsList(condition));
    }

}
