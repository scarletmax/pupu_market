package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.GoodsRank;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GoodsRankMapper {
   List<GoodsRank> findGoodsRank(HashMap<String,Object> hashMap);
   List<GoodsRank> findGoodsRank2(HashMap<String,Object> hashMap);
}
