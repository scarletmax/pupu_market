package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.Advertisement;
import com.cykj.marketpojo.Deliveryman;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdMapper {
    List<Advertisement> queryAd(HashMap<String, Object> condition);
    Integer queryCount(HashMap<String, Object> condition);
    List<String> getAllType();
    Integer updateState(@Param("id") int id,@Param("state") int state);
    Integer queryTypeCount(@Param("id") int id,@Param("shopId")int shopId);
    Integer updateAd(Advertisement ad);
    Integer newAd(Advertisement ad);


}
