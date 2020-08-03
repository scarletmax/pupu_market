package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TypeMapper {

    //分类列表和增删改查
    public int selectTypeNum(HashMap<String, Object> condition);
    public List<Type> selectTypeList(HashMap<String, Object> condition);
    public int updateType(Type type);
    public int insertType(Type type);
    public int deleteType(String id);
    public int isTypeRepeat(String name);
}
