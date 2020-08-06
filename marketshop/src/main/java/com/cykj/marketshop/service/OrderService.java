package com.cykj.marketshop.service;


import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.OrderDetail;

import java.util.HashMap;


public interface OrderService {
//点的列表
    LayData<OrderDetail> findOrderList(HashMap<String, Object> hashMap);
    //更改订单状态
    int changeState(HashMap<String, Object> hashMap);
}
