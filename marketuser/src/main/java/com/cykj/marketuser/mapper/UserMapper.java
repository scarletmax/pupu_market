package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserInfo(Integer id);
}
