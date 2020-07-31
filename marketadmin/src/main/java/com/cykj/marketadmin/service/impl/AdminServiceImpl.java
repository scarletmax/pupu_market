package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.AdminMapper;
import com.cykj.marketadmin.service.AdminService;
import com.cykj.marketadmin.util.MD5Util;
import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public LayData findAdminList(HashMap<String, Object> condition) {
        LayData layuiData = new LayData();
        List<Admin> adminList = adminMapper.findAdminList(condition);
        int count = adminMapper.findAdminCount(condition);
        if (adminList.size() > 0) {
            layuiData.setCode(0);
            layuiData.setMsg("");
            layuiData.setCount(count);
            layuiData.setData(adminList);
        } else {
            layuiData.setCode(1);
            layuiData.setMsg("加载失败");
        }
        return layuiData;
    }

    @Override
    public List<String> findAdminState() {
        List<String> adminList = null;
        adminList = adminMapper.findAdminState();
        return adminList;
    }

    @Override
    public boolean updateState(int id,String state) {
        int result = 0;
        Admin admin=new Admin();
        admin.setId(id);
        admin.setStateText(state);

        //更新审核状态
        result = adminMapper.updateState(id, state);
        return result > 0;
    }

    @Override
    public List<String> findAdminRole() {
        List<String> adminList = null;
        adminList = adminMapper.findAdminRole();
        return adminList;
    }
    @Override
    public int findAccount(String account) {
        int a=0;
        a = adminMapper.findAccount(account);
        return a;
    }
    @Override
    public int addAdmin(Admin admin) {
        int a=0;
        admin.setState(1);
        String pwd= MD5Util.md5(admin.getPwd());
        admin.setPwd(pwd);
        a = adminMapper.addAdmin(admin);
        return a;
    }
    @Override
    public List<String> findUserState() {
        List<String> userList = null;
        userList = adminMapper.findUserState();
        return userList;
    }
    @Override
    public LayData findUserList(HashMap<String, Object> condition) {
        LayData layuiData = new LayData();
        List<User> userList = adminMapper.findUserList(condition);
        int count = adminMapper.findUserCount(condition);
        if (userList.size() > 0) {
            layuiData.setCode(0);
            layuiData.setMsg("");
            layuiData.setCount(count);
            layuiData.setData(userList);
        } else {
            layuiData.setCode(1);
            layuiData.setMsg("加载失败");
        }
        return layuiData;
    }
    @Override
    public boolean updateUserState(int id,String state) {
        int result = 0;
        result = adminMapper.updateUserState(id, state);
        return result > 0;
    }
    @Override
    public boolean resetPwd(int id) {
        int result = 0;
        result = adminMapper.resetPwd(id);
        return result > 0;
    }

}

