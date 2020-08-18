package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.Deliveryman;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DeliverymanMapper {
    List<Deliveryman> queryDeliveryman(HashMap<String, Object> condition);
    Integer queryCount(HashMap<String, Object> condition);
    //更新派送员状态（审核/禁用/启用）
    Integer updateState(@Param("id") Integer id, @Param("state") String state);
    //获取所有派送员状态
    List<String> getAllState();
    double queryBenefit();
    Integer setBenefit(String benefit);
}
