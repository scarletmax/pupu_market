package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.PropertyService;
import com.cykj.marketadmin.service.TypeService;
import com.cykj.marketpojo.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/typeControl")
public class TypeControl {

    @Resource
    private TypeService typeService;
    @Resource
    private PropertyService propertyService;

    @RequestMapping("/findTypeState")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String findTypeState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(propertyService.findTypeState());
    }


    @RequestMapping("/searchTypeList")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String searchTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String curPage = request.getParameter("curPage");
        String pageSize = request.getParameter("pageSize");
        String name = request.getParameter("name");
        String parentId = request.getParameter("parentId");
        String state = request.getParameter("state");
        int curPage1 = Integer.parseInt(curPage);
        int pageSize1 = Integer.parseInt(pageSize);
        int offset1 = (curPage1-1)*pageSize1;
        HashMap<String,Object> condition = new HashMap<>();
        condition.put("offset",offset1);
        condition.put("pageSize",pageSize1);
        condition.put("name",name);
        condition.put("parentId",parentId);//mysql中的int和传上的string可以兼容
        condition.put("state",state);
        return JSON.toJSONString(typeService.searchTypeList(condition));
    }

    @RequestMapping("/editType")
    @ResponseBody
    @Log(operationType = "操作",operationName = "编辑商品类型")
    public String editType(Type type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.editType(type)+"");
    }

    @RequestMapping("/addType")
    @ResponseBody
    @Log(operationType = "操作",operationName = "新增商品类型")
    public String addType(Type type,HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(type.getIconUrl().equals("")){
            type.setIconUrl(File.separator+"测试图片.jpg");
        }
        return JSON.toJSONString(typeService.addType(type)+"");
    }

    @RequestMapping("/changeTypeState")
    @ResponseBody
    @Log(operationType = "操作",operationName = "删除商品类型")
    public String deleteType(String id,String state,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.changeTypeState(id,state)+"");
    }

    @RequestMapping("/isTypeRepeat")
    @ResponseBody
    public String isMenuRepeat(String name,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.isTypeRepeat(name)+"");
    }
}
