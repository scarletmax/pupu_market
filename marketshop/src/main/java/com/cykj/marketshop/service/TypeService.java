package com.cykj.marketshop.service;


import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Type;

import java.util.HashMap;
import java.util.List;

public interface TypeService {

    //一级分类
    public List<Type> parentTypeList();
    //二级分类
    public List<Type> typeList(String parentTypeId);

}
