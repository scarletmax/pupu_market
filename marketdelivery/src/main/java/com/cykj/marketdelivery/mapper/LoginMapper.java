package com.cykj.marketdelivery.mapper;

import com.cykj.marketpojo.Deliveryman;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    public int register(Deliveryman deliveryman);
}
