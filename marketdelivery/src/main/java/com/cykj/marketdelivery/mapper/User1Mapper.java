package com.cykj.marketdelivery.mapper;

import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Deliveryman login(Deliveryman deliveryman);
    Deliveryman getUserInfo(Integer id);
    int updateMoney(Deliveryman deliveryman);
}
