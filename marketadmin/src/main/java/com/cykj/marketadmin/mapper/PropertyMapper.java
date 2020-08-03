package com.cykj.marketadmin.mapper;

import com.cykj.marketpojo.Property;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PropertyMapper {

     List<Property> findProperty(HashMap<String, Object> hashMap);
     int findCount(HashMap<String, Object> hashMap);
     int changeProperty(HashMap<String, Object> hashMap);
}
