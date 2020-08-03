package com.cykj.marketadmin.service;


import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Type;

import java.util.HashMap;

public interface TypeService {

    //菜单列表
    public LayData<Type> searchTypeList(HashMap<String, Object> condition);
    //菜单编辑
    public int editType(Type type);
    //菜单增加
    public int addType(Type type);
    //菜单移除
    public int removeType(String id);
    //菜单查重
    public int isTypeRepeat(String name);
}
