package com.cykj.marketadmin.service;

import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Property;

import java.util.HashMap;
import java.util.List;

public interface PropertyService {
//参数列表
    LayData<Property> findProperty(HashMap<String, Object> hashMap);
    //参数总数
    int findCount(HashMap<String, Object> hashMap);
    //修改参数
    int changeProperty(HashMap<String, Object> hashMap);
    //查询分类的参数类型
    List<Property> findTypeState();
}
