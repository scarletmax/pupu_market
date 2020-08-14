package com.cykj.marketuser.service;


import com.cykj.marketpojo.OrderDetail;

import java.util.List;

public interface OrderService {
    public List<OrderDetail> selectOrderAndGoods(int userId);

}
