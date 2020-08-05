package com.cykj.marketshop.mapper;


import com.cykj.marketpojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TypeMapper {

    //一级分类
    public List<Type> parentTypeList();
    //二级分类
    public List<Type> typeList(String parentTypeId);
}
