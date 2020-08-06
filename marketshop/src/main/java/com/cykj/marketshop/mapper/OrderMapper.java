package com.cykj.marketshop.mapper;


import com.cykj.marketpojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrderMapper {


    List<OrderDetail> findOrderList(HashMap<String, Object> hashMap);
    int findOrderCount(HashMap<String, Object> hashMap);
    //更改订单状态
    int changeState(HashMap<String, Object> hashMap);
}
