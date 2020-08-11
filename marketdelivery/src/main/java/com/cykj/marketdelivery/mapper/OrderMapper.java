package com.cykj.marketdelivery.mapper;


import com.cykj.marketpojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrderMapper {


    List<OrderDetail> findOrderList(HashMap<String, Object> hashMap);
    int findOrderCount(HashMap<String, Object> hashMap);
}
