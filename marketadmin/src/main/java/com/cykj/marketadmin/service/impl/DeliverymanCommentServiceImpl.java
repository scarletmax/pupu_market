package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.DeliverymanCommentMapper;
import com.cykj.marketadmin.service.DeliverymanCommentService;
import com.cykj.marketpojo.DeliverymanComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
