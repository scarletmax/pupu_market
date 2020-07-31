package com.cykj.marketadmin.service;




import com.cykj.marketpojo.AttrMsg;
import com.cykj.marketpojo.Menu;
import com.cykj.marketpojo.Role;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu(int roleId);
    //     获取所有权限
    List<Role> getAllRole();
    //查询已分配和未分配菜单
    public AttrMsg queryAttr(int roleId);
    //移除已分配的菜单
    public boolean removeAttr(int roleId, String arr);
    //分配新的菜单
    public boolean newAttr(int roleId, String arr);
}
