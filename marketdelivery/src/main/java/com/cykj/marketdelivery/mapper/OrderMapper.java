package com.cykj.marketdelivery.mapper;


import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.Property;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrderMapper {


    List<OrderDetail> findOrderList(HashMap<String, Object> hashMap);

    int findOrderCount(HashMap<String, Object> hashMap);

    List<OrderDetail> deliverOrder(HashMap<String, Object> hashMap);//查询派送订单

    Property findDelivermoney();//查询快递员收益
}