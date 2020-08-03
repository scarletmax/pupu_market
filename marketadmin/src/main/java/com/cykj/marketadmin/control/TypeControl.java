package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.TypeService;
import com.cykj.marketpojo.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/typeControl")
public class TypeControl {

    @Resource
    private TypeService typeService;


    @RequestMapping("/searchTypeList")
    @ResponseBody
    public String searchTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String curPage = request.getParameter("curPage");
        String pageSize = request.getParameter("pageSize");
        String name = request.getParameter("name");
        String parentId = request.getParameter("parentId");
        int curPage1 = Integer.parseInt(curPage);
        int pageSize1 = Integer.parseInt(pageSize);
        int offset1 = (curPage1-1)*pageSize1;
        HashMap<String,Object> condition = new HashMap<>();
        condition.put("offset",offset1);
        condition.put("pageSize",pageSize1);
        condition.put("name",name);
        condition.put("parentId",parentId);//mysql中的int和传上的string可以兼容
        return JSON.toJSONString(typeService.searchTypeList(condition));
    }

    @RequestMapping("/editType")
    @ResponseBody
    public String editType(Type type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.editType(type)+"");
    }

    @RequestMapping("/addType")
    @ResponseBody
    public String addType(Type type,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.addType(type)+"");
    }

    @RequestMapping("/removeType")
    @ResponseBody
    public String deleteType(String id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.removeType(id)+"");
    }

    @RequestMapping("/isTypeRepeat")
    @ResponseBody
    public String isMenuRepeat(String name,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.isTypeRepeat(name)+"");
    }
}
