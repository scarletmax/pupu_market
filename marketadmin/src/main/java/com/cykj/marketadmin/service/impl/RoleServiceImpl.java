package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.RoleMapper;
import com.cykj.marketadmin.service.RoleService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public LayData<Role> searchRoleList() {
        LayData<Role> layData = new LayData<>();
        layData.setData(roleMapper.selectRoleList());
        return layData;
    }

    @Override
    public int editRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Override
    public int isRoleRepeat(String name) {
        return roleMapper.isRoleRepeat(name);
    }
}
