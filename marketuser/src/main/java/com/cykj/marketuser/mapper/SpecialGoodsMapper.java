package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecialGoodsMapper {

    List<Goods> findSpecialGoods();
}
