package com.cykj.marketadmin.service;




import com.cykj.marketpojo.AttrMsg;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Menu;
import com.cykj.marketpojo.Role;

import java.util.HashMap;
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
    //菜单列表
    public LayData<Menu> searchMenuList(HashMap<String,Object> condition);
    //菜单编辑
    public int editMenu(Menu menu);
    //菜单增加
    public int addMenu(Menu menu);
    //菜单移除
    public int removeMenu(String id);
    //菜单查重
    public int isMenuRepeat(String name);
}
