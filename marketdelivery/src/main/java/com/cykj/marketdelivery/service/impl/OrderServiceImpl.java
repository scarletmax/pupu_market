package com.cykj.marketdelivery.service.impl;



import com.cykj.marketdelivery.mapper.Order1Mapper;
import com.cykj.marketdelivery.service.OrderService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private Order1Mapper orderMapper;

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

    @Override
    public List<OrderDetail> deliverOrder(HashMap<String, Object> hashMap) {
        return orderMapper.deliverOrder(hashMap);
    }

    @Override
    public Property findDelivermoney() {
        return orderMapper.findDelivermoney();
    }
}
