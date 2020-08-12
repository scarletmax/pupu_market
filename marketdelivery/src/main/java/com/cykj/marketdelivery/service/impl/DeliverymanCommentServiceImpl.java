package com.cykj.marketdelivery.service.impl;




import com.cykj.marketdelivery.mapper.CommentMapper;
import com.cykj.marketdelivery.service.DeliverymanCommentService;
import com.cykj.marketpojo.DeliverymanComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DeliverymanCommentServiceImpl implements DeliverymanCommentService {

    @Autowired
    private CommentMapper deliverymanCommentMapper;


    @Override
    public List<DeliverymanComment> findDeliverymanComment(HashMap<String, Object> hashMap) {
        return deliverymanCommentMapper.findDeliverymanComment(hashMap);
    }
}
