package com.cykj.marketadmin.service;



import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.LayData;

import java.util.HashMap;
import java.util.List;

public interface AdminService {
    public LayData findAdminList(HashMap<String, Object> condition);
    public List<String> findAdminState();
    public boolean updateState(int id, String state);
    public List<String> findAdminRole();
    public int findAccount(String account);
    public int addAdmin(Admin admin);
    public List<String> findUserState();
    public LayData findUserList(HashMap<String, Object> condition);
    public boolean updateUserState(int id, String state);
    public boolean resetPwd(int id);
}
