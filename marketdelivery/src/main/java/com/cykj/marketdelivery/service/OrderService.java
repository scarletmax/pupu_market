package com.cykj.marketdelivery.service;


import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.Property;

import java.util.HashMap;
import java.util.List;


public interface OrderService {
//点的列表
    LayData<OrderDetail> findOrderList(HashMap<String, Object> hashMap);
    List<OrderDetail> deliverOrder(HashMap<String, Object> hashMap);//查询派送的订单
    Property findDelivermoney();
}
