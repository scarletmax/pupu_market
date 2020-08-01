package com.cykj.marketadmin.service;


import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Role;

public interface RoleService {
   //角色列表和增删改查
    public LayData<Role> searchRoleList();
    public int editRole(Role role);
    public int addRole(Role role);
    public int isRoleRepeat(String name);
}
