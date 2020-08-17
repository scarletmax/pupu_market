package com.cykj.marketdelivery.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketdelivery.service.UserService;
import com.cykj.marketdelivery.util.MD5Util;
import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cykj.marketpojo.Deliveryman;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("userControl")
public class UserControl {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String code,String mobile, HttpServletRequest request){
        String pwd= MD5Util.md5(code);
        Deliveryman deliveryman=new Deliveryman();
        deliveryman.setPwd(pwd);
        deliveryman.setTel(mobile);
        deliveryman = userService.login(deliveryman);
        if (deliveryman==null){
            deliveryman.setState(0);
        }
        return JSON.toJSONString(deliveryman);
    }

    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public String getUserInfo(String id, HttpServletRequest request){
        Deliveryman deliveryman = userService.getUserInfo(Integer.valueOf(id).intValue());
        return JSON.toJSONString(deliveryman);
    }
}
