package com.cykj.marketdelivery.mapper;


import com.cykj.marketpojo.DeliverymanComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CommentMapper {

    List<DeliverymanComment> findDeliverymanComment(HashMap<String, Object> hashMap);
}
