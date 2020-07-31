package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminMapper {
    List<Admin> findAdminList(HashMap<String, Object> condition);
    int  findAdminCount(HashMap<String, Object> condition);
    List<String> findAdminState();
    int updateState(int id, String state);
    List<String> findAdminRole();
    int findAccount(String account);
    int addAdmin(Admin admin);
    List<String> findUserState();
    List<User> findUserList(HashMap<String, Object> condition);
    int  findUserCount(HashMap<String, Object> condition);
    int updateUserState(int id, String state);
    int resetPwd(int id);
}