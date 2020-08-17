package com.cykj.marketdelivery.service;

import com.cykj.marketpojo.DeliverMsg;
import com.cykj.marketpojo.Marker;
import com.cykj.marketpojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GetOrderService {
    List<OrderDetail> showAvailOrder();

    List<Marker> getAllShopMarkers();
    String  getOrder(int deliverymanId, int id );
    List<OrderDetail> showCurOrders(int deliverymanId);
    DeliverMsg getRouteMsg(int id,double longitude,double latitude);
    String arriveShop(int id);
    String arriveCustomer(int id);


}
