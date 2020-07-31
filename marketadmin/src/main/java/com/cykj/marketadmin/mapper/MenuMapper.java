package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getMenu(int roleId);

    //根据角色，父目录查询菜单
    public List<Menu> getMenuByPid(@Param("id") int id, @Param("roleId") int roleId);
    //根据角色id查询已分配菜单
     List<Menu> queryAttr(int roleId);
//    //根据角色id查询未分配菜单
//     List<Menu> queryUnAttr(int roleId);
    //根据父目录查询所有菜单
     List<Menu> queryAllChild();
    //根据菜单id获取菜单
     Menu getMenuById(int id);
    //移除已分配的菜单
     boolean removeAttr(@Param("roleId") int roleId, @Param("id") int id);
    //新增分配菜单
     boolean newAttr(@Param("roleId") int roleId, @Param("id") int id);
    //获取还没插入的父级菜单
     List<Integer> getUnInsert(int roleId);
}
