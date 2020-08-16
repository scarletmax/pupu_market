package com.cykj.marketdelivery.service.impl;

import com.cykj.marketdelivery.mapper.GetOrderMapper;
import com.cykj.marketdelivery.service.GetOrderService;
import com.cykj.marketpojo.Marker;
import com.cykj.marketpojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("getOrderService")
public class GetOrderServiceImpl implements GetOrderService {
    @Autowired
    private GetOrderMapper getOrderMapper;

    @Override
    public List<OrderDetail> showAvailOrder() {
        return getOrderMapper.showAvailOrder();
    }

    @Override
    public List<Marker> getAllShopMarkers() {
        return getOrderMapper.getAllShopMarkers();
    }

    @Override
    public String getOrder(int deliverymanId, int id) {
        return getOrderMapper.getOrder(deliverymanId,id)>0?"success":"fail";
    }

    @Override
    public List<OrderDetail> showCurOrders(int deliverymanId) {
        return getOrderMapper.showCurOrders(deliverymanId);
    }
}
