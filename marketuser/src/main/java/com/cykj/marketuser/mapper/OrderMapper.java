package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.ReceiverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    public List<OrderDetail> selectOrderAndGoods(int userId);
    public int cancelOrder(int orderId);

    ReceiverInfo getAddress(int userId);
    Integer createOrder(OrderDetail detail);
    Integer insertGoods(Goods goods);



}
