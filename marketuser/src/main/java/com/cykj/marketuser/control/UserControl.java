package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketuser.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("userControl")
public class UserControl {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public String getUserInfo(Integer id){
        return JSON.toJSONString(userService.getUserInfo(id));
    }
}
