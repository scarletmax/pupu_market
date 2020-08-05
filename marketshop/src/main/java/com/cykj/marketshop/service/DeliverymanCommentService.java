package com.cykj.marketshop.service;



import com.cykj.marketpojo.DeliverymanComment;

import java.util.HashMap;
import java.util.List;

public interface DeliverymanCommentService {
//派送员评论
    List<DeliverymanComment> findDeliverymanComment(HashMap<String, Object> hashMap);
}
