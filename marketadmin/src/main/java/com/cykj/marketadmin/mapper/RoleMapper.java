package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    //角色列表和增删改查
    public List<Role> selectRoleList();
    public int updateRole(Role role);
    public int insertRole(Role role);
    public int isRoleRepeat(String name);
}
