package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //检查是否存在该openid
    User checkOpenid(User user);
    Integer insertWeixinUser(User user);
    User loginByWeixin(User user);
    User loginByTel(User user);
}
