package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.AdminService;
import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("adminControl")
public class AdminControl {
    @Autowired
    private AdminService adminService;
//    查询管理员列表信息
    @RequestMapping(value = "/findAdminList")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String findAdminList(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        HashMap<String, Object> condition = new HashMap<>();
        String account = request.getParameter("account");
        if (account != null && !account.trim().equals("")) {
            condition.put("account", account);
        }
        String name = request.getParameter("name");
        if (name != null && !name.trim().equals("")) {
            condition.put("name", name);
        }
        String stateText = request.getParameter("stateText");
        if (stateText != null && !stateText.trim().equals("")) {
            condition.put("stateText", stateText);
        }
        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        int start = (pageNum - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        condition.put("start", start);
        condition.put("pageSize", pageSize);
        LayData layuiData = new LayData();
        layuiData = adminService.findAdminList(condition);
        return JSON.toJSONString(layuiData);
    }
//    查询管理员状态
    @RequestMapping(value = "/findAdminState")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String findAdminState(HttpServletRequest request, HttpServletResponse response) {
        List<String> adminList= adminService.findAdminState();
        return JSON.toJSONString(adminList);
    }
//    修改管理员状态
    @RequestMapping("/updateState")
    @ResponseBody
    @Log(operationType = "操作",operationName = "更改管理员状态")
    public String updateState(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String state = request.getParameter("state");
        if (adminService.updateState(id, state)) {
            return "success";
        } else {
            return "fail";
        }
    }
//    查询管理员角色
    @RequestMapping(value = "/findAdminRole")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String findAdminRole(HttpServletRequest request, HttpServletResponse response) {
        List<String> adminList= adminService.findAdminRole();
        return JSON.toJSONString(adminList);
    }
//    查询管理员人数
    @RequestMapping(value = "/findAccount")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String findAccount(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        int a=0;
        a= adminService.findAccount(account);
        if (a == 0) {
            return "success";
        } else {
            return "fail";
        }
    }
//    新增管理员
    @RequestMapping(value = "/addAdmin")
    @ResponseBody
    @Log(operationType = "操作",operationName = "新增管理员")
    public String addAdmin(HttpServletRequest request, HttpServletResponse response) {
        String adminJson= request.getParameter("adminJson");
        Admin admin= JSON.parseObject(adminJson, Admin.class);
        int a=0;
        if (admin!=null){
            a= adminService.findAccount(admin.getAccount());
            if (a!=0){
                return "fail";
            }else{
                a=adminService.addAdmin(admin);
                if (a == 1) {
                    return "success";
                } else {
                    return "fail";
                }
            }
        }else {
            return "fail";
        }
    }
//    查询用户状态
    @RequestMapping(value = "/findUserState")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String findUserState(HttpServletRequest request, HttpServletResponse response) {
        List<String> userList= adminService.findUserState();
        return JSON.toJSONString(userList);
    }
//    查询用户列表
    @RequestMapping(value = "/findUserList")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String findUserList(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        HashMap<String, Object> condition = new HashMap<>();
        String account = request.getParameter("account");
        if (account != null && !account.trim().equals("")) {
            condition.put("account", account);
        }
        String name = request.getParameter("name");
        if (name != null && !name.trim().equals("")) {
            condition.put("name", name);
        }
        String stateStr = request.getParameter("stateStr");
        if (stateStr != null && !stateStr.trim().equals("")) {
            condition.put("stateStr", stateStr);
        }
        String levelName = request.getParameter("levelName");
        if (levelName != null && !levelName.trim().equals("")) {
            condition.put("levelName", levelName);
        }
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        if (startDate != null && !startDate.trim().equals("")) {
            condition.put("startDate", startDate);
        } else {
            startDate = "";
        }
        if (endDate != null && !endDate.trim().equals("")) {
            condition.put("endDate", endDate);
        } else {
            endDate = "";
        }

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        int start = (pageNum - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        condition.put("start", start);
        condition.put("pageSize", pageSize);
        LayData layuiData = new LayData();
        layuiData = adminService.findUserList(condition);
        return JSON.toJSONString(layuiData);
    }
//    修改用户状态
    @RequestMapping("/updateUserState")
    @ResponseBody
    @Log(operationType = "操作",operationName = "更改用户状态")
    public String updateUserState(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String state = request.getParameter("state");
        if (adminService.updateUserState(id, state)) {
            return "success";
        } else {
            return "fail";
        }
    }
//    重置密码
    @RequestMapping("/resetPwd")
    @ResponseBody
    @Log(operationType = "操作",operationName = "重置密码")
    public String resetPwd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (adminService.resetPwd(id)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
