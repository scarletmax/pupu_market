package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketshop.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/typeControl")
public class TypeControl {

    @Resource
    private TypeService typeService;

    @RequestMapping("/parentTypeList")
    @ResponseBody
    public String parentTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.parentTypeList());
    }

    @RequestMapping("/typeList")
    @ResponseBody
    public String typeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(typeService.typeList(request.getParameter("parentTypeId")));
    }


}
