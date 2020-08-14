package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketuser.mapper.OrderMapper;
import com.cykj.marketuser.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Override
    public List<OrderDetail> selectOrderAndGoods(int userId) {
        return orderMapper.selectOrderAndGoods(userId);
    }
}
