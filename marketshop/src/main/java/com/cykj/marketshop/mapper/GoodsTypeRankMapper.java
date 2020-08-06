package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.GoodsTypeRank;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GoodsTypeRankMapper {

    List<GoodsTypeRank> findGoodsTypeRank(HashMap<String,Object> hashMap);

}
