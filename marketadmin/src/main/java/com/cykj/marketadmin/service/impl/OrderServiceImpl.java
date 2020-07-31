package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.OrderMapper;
import com.cykj.marketadmin.service.OrderService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Override
    public LayData<OrderDetail> findOrderList(HashMap<String, Object> hashMap) {

        LayData<OrderDetail> layData=new LayData<>();
        List<OrderDetail> list=orderMapper.findOrderList(hashMap);
        int total=orderMapper.findOrderCount(hashMap);
        layData.setData(list);
        layData.setCount(total);
        layData.setMsg("");

        return layData;
    }
}
