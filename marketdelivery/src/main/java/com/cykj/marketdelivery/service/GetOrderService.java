package com.cykj.marketdelivery.service;

import com.cykj.marketpojo.Marker;
import com.cykj.marketpojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GetOrderService {
    List<OrderDetail> showAvailOrder();

    List<Marker> getAllShopMarkers();
    String  getOrder(int deliverymanId, int id );


}
