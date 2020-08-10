package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    List<Type> getAllType();
}
