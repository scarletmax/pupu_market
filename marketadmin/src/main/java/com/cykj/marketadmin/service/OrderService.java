package com.cykj.marketadmin.service;


import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.OrderDetail;

import java.util.HashMap;


public interface OrderService {

    LayData<OrderDetail> findOrderList(HashMap<String, Object> hashMap);
}
