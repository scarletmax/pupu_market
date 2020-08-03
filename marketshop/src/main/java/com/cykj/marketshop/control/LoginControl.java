package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/loginControl")
public class LoginControl {
    @Autowired
    public LoginService loginService;

    @RequestMapping(value = "/login")
    @ResponseBody
//    @Log(operationType = "操作",operationName = "管理员登录")
    //管理员登录
    public String login(HttpServletRequest request)  {
        String adminJson = request.getParameter("adminJson");
        System.out.println(adminJson);
        ShopAdmin userAdmin = JSON.parseObject(adminJson, ShopAdmin.class);
        ShopAdmin admin= loginService.login(userAdmin);
        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            request.getSession().setAttribute("isLogin", true);
            return "success";
        } else {
            return "error";
        }
    }
}
