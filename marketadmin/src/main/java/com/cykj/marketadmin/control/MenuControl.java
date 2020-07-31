package com.cykj.online_market_admin.control;


import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.MenuService;
import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.AttrMsg;
import com.cykj.marketpojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/menuControl")
public class MenuControl {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/getMenu")
//    @Log(operationType = "查看",operationName = "")
    //获得菜单
    public String getMenu(HttpServletRequest request, HttpServletResponse response)   {
        System.out.println("菜单方法");
        Admin admin= (Admin)request.getSession().getAttribute("admin");
        int roleId=admin.getRoleId();
        List<Menu> menuList= menuService.getMenu(roleId);
        request.setAttribute("menuList",menuList);
        return "/jsp/main.jsp";
    }
    @RequestMapping("queryAttr")
    @ResponseBody
    public String queryAttr(HttpServletRequest request) {
        int roleId= Integer.parseInt(request.getParameter("roleId"));
        AttrMsg attrMsg= menuService.queryAttr(roleId);
        return JSON.toJSONString(attrMsg);

    }
    @RequestMapping("removeAttr")
    @ResponseBody
    //移除已分配的菜单
    public String removeAttr(HttpServletRequest request)  {
        String  menuIdArr= request.getParameter("MenuIdArr");
        int roleId= Integer.parseInt(request.getParameter("roleId"));
        if(menuService.removeAttr(roleId,menuIdArr)){
            return "success";
        }else {
            return "fail";
        }
    }
    @RequestMapping("newAttr")
    @ResponseBody
    //分配新的菜单
    public String newAttr(HttpServletRequest request) {
        String  menuIdArr= request.getParameter("MenuIdArr");
        int roleId= Integer.parseInt(request.getParameter("roleId"));
        System.out.println("后端收到的arr"+menuIdArr);
        System.out.println("后端收到的arr"+menuIdArr.toString());
        if(menuService.newAttr(roleId,menuIdArr)){
            return "success";
        }else {
            return "fail";
        }

    }
    @RequestMapping("getAllRole")
    @ResponseBody
    public String getAllRole() {
        return JSON.toJSONString(menuService.getAllRole());
    }


}
