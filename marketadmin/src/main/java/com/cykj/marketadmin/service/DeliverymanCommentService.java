package com.cykj.marketadmin.service;



import com.cykj.marketpojo.DeliverymanComment;

import java.util.HashMap;
import java.util.List;

public interface DeliverymanCommentService {

    List<DeliverymanComment> findDeliverymanComment(HashMap<String, Object> hashMap);
}
