package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.DeliverymanComment;
import com.cykj.marketpojo.GoodsComment;
import com.cykj.marketuser.mapper.CommentMapper;
import com.cykj.marketuser.mapper.OrderMapper;
import com.cykj.marketuser.service.CommentService;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private OrderMapper orderMapper;

    @Override
    public void insertComment(DeliverymanComment deliverymanComment, GoodsComment goodsComment) throws Exception{
        try {
            int res1 = commentMapper.insertDC(deliverymanComment);
            int[] goodsIdArr = goodsComment.getGoodsIdArr();
            for (int b: goodsIdArr) {
                goodsComment.setGoodsId(b);
                int res2 = commentMapper.insertGC(goodsComment);
            }
            orderMapper.orderCommented(deliverymanComment.getOrderDetailId());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }
}
