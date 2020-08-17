package com.cykj.marketdelivery.service.impl;

import com.cykj.marketdelivery.mapper.GetOrderMapper;
import com.cykj.marketdelivery.service.GetOrderService;
import com.cykj.marketpojo.DeliverMsg;
import com.cykj.marketpojo.Marker;
import com.cykj.marketpojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public DeliverMsg getRouteMsg(int id, double longitude, double latitude) {
        //获取线路信息
        DeliverMsg msg = getOrderMapper.getRouteMsg(id);
        msg.setOriLatitude(latitude);
        msg.setOriLongitude(longitude);
        msg.setOrigin(longitude+","+latitude);
        msg.setWaypoints(msg.getWayLongitude()+","+msg.getWayLatitude());
        msg.setDestination(msg.getDesLongitude()+","+msg.getDesLatitude());
        //设置markers
        Marker oriMarker=new Marker("我的位置",longitude,latitude);
        Marker desMarker= new Marker("买家地址",msg.getDesLongitude(),msg.getDesLatitude());
        Marker wayMarker= new Marker("店家位置",msg.getWayLongitude(),msg.getWayLatitude());
        List<Marker> markers =new ArrayList<>();
        markers.add(oriMarker);
        markers.add(desMarker);
        markers.add(wayMarker);
        msg.setMarkers(markers);
        //获取提成
        msg.setBenefit(getOrderMapper.getBenefit());
        //获取送达时间
        msg.setArriveHour(getOrderMapper.getArriveHour(id));
        msg.setArriveDate(getOrderMapper.getArriveTime(id));
        //订单号
        msg.setOrderNum(getOrderMapper.getOrderNum(id));
        msg.setTel(getOrderMapper.getTel(id));
        return msg;

    }

    @Override
    public String arriveShop(int id) {
        return getOrderMapper.arriveShop(id)>0 ?"success":"fail";
    }

    @Override
    public String arriveCustomer(int id) {
        return getOrderMapper.arriveCustomer(id)>0 ?"success":"fail";
    }
}
