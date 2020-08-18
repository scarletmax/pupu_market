package com.cykj.marketadmin.control;


import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/menuControl")
public class MenuControl {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/getMenu")
    @Log(operationType = "查看",operationName = "")
//    @Log(operationType = "查看",operationName = "")
    //获得菜单
    public String getMenu(HttpServletRequest request, HttpServletResponse response)   {
        System.out.println("菜单方法");
        Admin admin= (Admin)request.getSession().getAttribute("admin");
        System.out.println("admin"+admin);
        int roleId=admin.getRoleId();
        List<Menu> menuList= menuService.getMenu(roleId);
        request.setAttribute("menuList",menuList);
        return "/jsp/main.jsp";
    }
    @RequestMapping("queryAttr")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String queryAttr(HttpServletRequest request) {
        int roleId= Integer.parseInt(request.getParameter("roleId"));
        AttrMsg attrMsg= menuService.queryAttr(roleId);
        return JSON.toJSONString(attrMsg);

    }
    @RequestMapping("removeAttr")
    @ResponseBody
    @Log(operationType = "操作",operationName = "移除菜单权限")
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
    @Log(operationType = "操作",operationName = "新分配菜单权限")
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
    @Log(operationType = "查看",operationName = "")
    public String getAllRole() {
        return JSON.toJSONString(menuService.getAllRole());
    }

    @RequestMapping("/searchMenuList")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String searchMenuList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("菜单列表");
        String name = request.getParameter("name");
        String parentId = request.getParameter("parentId");
        HashMap<String,Object> condition = new HashMap<>();
        condition.put("name",name);
        condition.put("parentId",parentId);//mysql中的int和传上的string可以兼容
        return JSON.toJSONString(menuService.searchMenuList(condition));
    }

    @RequestMapping("/editMenu")
    @ResponseBody
    @Log(operationType = "操作",operationName = "编辑菜单")
    public String editMenu(Menu menu,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(menuService.editMenu(menu)+"");
    }

    @RequestMapping("/addMenu")
    @ResponseBody
    @Log(operationType = "操作",operationName = "新增菜单")
    public String addMenu(Menu menu,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(menuService.addMenu(menu)+"");
    }

    @RequestMapping("/removeMenu")
    @ResponseBody
    @Log(operationType = "操作",operationName = "移除菜单")
    public String deleteMenu(String id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(menuService.removeMenu(id)+"");
    }

    @RequestMapping("/isMenuRepeat")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String isMenuRepeat(String name,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(menuService.isMenuRepeat(name)+"");
    }


}
