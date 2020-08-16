package com.cykj.marketuser.service;


import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.ReceiverInfo;

import java.util.List;

public interface OrderService {
    public List<OrderDetail> selectOrderAndGoods(int userId);
    public int cancelOrder(int orderId);
    public int deleteOrder(int orderId);

    OrderDetail getRelativeInfo(int userId);
    String createOrder(int userId, int shopId, ReceiverInfo receiverInfo, List<Goods> goodsList,double totalPrice);


}
