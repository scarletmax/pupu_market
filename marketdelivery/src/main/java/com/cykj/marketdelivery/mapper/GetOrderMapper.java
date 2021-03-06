package com.cykj.marketdelivery.mapper;

import com.cykj.marketpojo.DeliverMsg;
import com.cykj.marketpojo.Marker;
import com.cykj.marketpojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GetOrderMapper {
    List<OrderDetail> showAvailOrder();
    Integer getOrder(@Param("deliverymanId")int deliverymanId,@Param("id")int id );
    Integer arriveShop(int id);
    Integer arriveCustomer(int id);
    List<Marker> getAllShopMarkers();
    List<OrderDetail> showCurOrders(int deliverymanId);
    DeliverMsg getRouteMsg(int id);
    String getBenefit();
    String getArriveTime(int id);
    String getArriveHour(int id);
    String getOrderNum(int id);
    String getTel(int id);

}
