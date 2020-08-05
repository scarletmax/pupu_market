package com.cykj.marketuser.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.cykj.marketpojo.Goods;
import java.util.List;

@Mapper
public interface GoodMapper {
    List<Goods> getSpecialGood(int shopId);
    List<Goods> getHighSaleGood(int shopId);
    List<Goods> getRecommendedGood(int shopId);
}
