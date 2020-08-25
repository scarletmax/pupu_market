package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.RoleService;
import com.cykj.marketpojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/roleControl")
public class RoleControl {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/searchRoleList")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String searchMenuList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(roleService.searchRoleList());

    }

    @RequestMapping("/editRole")
    @ResponseBody
    @Log(operationType = "操作",operationName = "编辑角色")
    public String editRole(Role role, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(roleService.editRole(role)+"");
    }

    @RequestMapping("/addRole")
    @ResponseBody
    @Log(operationType = "操作",operationName = "新增角色")
    public String addRole(Role role, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(roleService.addRole(role)+"");
    }

    @RequestMapping("/isRoleRepeat")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String isRoleRepeat(String name,HttpServletRequest request, HttpServletResponse response) throws IOException {
        return JSON.toJSONString(roleService.isRoleRepeat(name)+"");
    }
}
