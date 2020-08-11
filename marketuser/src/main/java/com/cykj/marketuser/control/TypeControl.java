package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketuser.service.TypeService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("typeControl")
public class TypeControl {
    @Autowired
    private TypeService typeService;
    @ResponseBody
    @RequestMapping("getAllType")
    public String  getAllType (){
        return JSON.toJSONString(typeService.getAllType());
    }
}
