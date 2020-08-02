package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GoodsMapper {

    public int selectGoodsNum(HashMap<String, Object> condition);
    public List<Goods> selectGoodsList(HashMap<String, Object> condition);
}
