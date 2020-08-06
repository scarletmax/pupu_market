package com.cykj.marketshop.service.impl;




import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketshop.mapper.OrderMapper;
import com.cykj.marketshop.service.OrderService;
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

    @Override
    public int changeState(HashMap<String, Object> hashMap) {
        return orderMapper.changeState(hashMap);
    }
}
