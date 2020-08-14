package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    public List<OrderDetail> selectOrderAndGoods(int userId);
}
