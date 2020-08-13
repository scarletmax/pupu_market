package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.ReceiverInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    ReceiverInfo getAddress(int userId);
    Integer createOrder(OrderDetail detail);
    Integer insertGoods(Goods goods);


}
