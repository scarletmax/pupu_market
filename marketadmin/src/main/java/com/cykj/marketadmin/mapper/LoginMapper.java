package com.cykj.marketadmin.mapper;



import com.cykj.marketpojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //管理员登录
    Admin login(Admin admin);
}
