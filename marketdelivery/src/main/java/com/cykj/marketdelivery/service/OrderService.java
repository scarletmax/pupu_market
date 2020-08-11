package com.cykj.marketdelivery.service;


import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.OrderDetail;

import java.util.HashMap;


public interface OrderService {
//点的列表
    LayData<OrderDetail> findOrderList(HashMap<String, Object> hashMap);
}
