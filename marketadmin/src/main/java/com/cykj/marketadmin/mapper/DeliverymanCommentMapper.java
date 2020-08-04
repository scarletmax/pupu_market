package com.cykj.marketadmin.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliverymanCommentMapper {

    List<DeliverymanComment> findDeliverymanComment(HashMap<String, Object> hashMap);
}
