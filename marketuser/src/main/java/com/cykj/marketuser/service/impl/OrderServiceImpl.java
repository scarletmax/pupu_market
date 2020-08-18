package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.OrderDetail;
import com.cykj.marketpojo.ReceiverInfo;
import com.cykj.marketuser.mapper.CartMapper;
import com.cykj.marketuser.mapper.OrderMapper;
import com.cykj.marketuser.service.OrderService;
import com.cykj.marketuser.util.OrderNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private CartMapper cartMapper;

    @Override
    public List<OrderDetail> selectOrderAndGoods(int userId) { return orderMapper.selectOrderAndGoods(userId);}

    @Override
    public int cancelOrder(int orderId) {
        return orderMapper.cancelOrder(orderId);
    }

    @Override
    public int deleteOrder(int orderId) {
        return orderMapper.deleteOrder(orderId);
    }

    @Override
    public int confirmAccept(int orderId) {
        return orderMapper.confirmAccept(orderId);
    }

    @Override
    public OrderDetail getRelativeInfo(int userId) {
        OrderDetail detail= new OrderDetail();
        detail.setReceiverInfo(orderMapper.getAddress(userId));
        return detail;
    }

    @Override
    @Transactional
    public String createOrder(int userId, int shopId, ReceiverInfo receiverInfo, List<Goods> goodsList, double totalPrice) {
       //获取订单号
        String orderNum= OrderNumUtil.getOrderNum();
        //订单详情设置
        OrderDetail detail= new OrderDetail(totalPrice,orderNum,receiverInfo.getName(),receiverInfo.getAddress(),receiverInfo.getRoomNum(),receiverInfo.getLongitude(),receiverInfo.getLatitude(),receiverInfo.getTel(),userId,shopId);
        //插入
        boolean flag=true;
        if(orderMapper.createOrder(detail)>0) {
            int orderDetailId=detail.getId();

            //插入订单商品数据
            for (int i = 0; i <goodsList.size(); i++) {
                goodsList.get(i).setOrderDetailId(orderDetailId);
                int res= orderMapper.insertGoods(goodsList.get(i));
                if(res==0){
                    flag=false;
                }
            }
            //清空购物车
            if(flag) {
                cartMapper.clearCart(userId,shopId);
            }
        }
        return flag ? orderNum:"fail";
    }
}
