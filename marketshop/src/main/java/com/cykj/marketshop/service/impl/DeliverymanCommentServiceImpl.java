package com.cykj.marketshop.service.impl;


import com.cykj.marketpojo.DeliverymanComment;
import com.cykj.marketshop.mapper.DeliverymanCommentMapper;
import com.cykj.marketshop.service.DeliverymanCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DeliverymanCommentServiceImpl implements DeliverymanCommentService {

    @Autowired
    private DeliverymanCommentMapper deliverymanCommentMapper;

    @Override
    public List<DeliverymanComment> findDeliverymanComment(HashMap<String, Object> hashMap) {
        return deliverymanCommentMapper.findDeliverymanComment(hashMap);
    }
}
