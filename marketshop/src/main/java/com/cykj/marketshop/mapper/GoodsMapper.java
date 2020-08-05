package com.cykj.marketshop.mapper;


import com.cykj.marketpojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GoodsMapper {

    public int selectGoodsNum(HashMap<String, Object> condition);
    public List<Goods> selectGoodsList(HashMap<String, Object> condition);
    public int startRecommended(String id);
    public int endRecommended(String id);
    public int startSpecial(String id);
    public int endSpecial(String id);
    public int putaway(int[] idArr);
    public int unshelve(int[] idArr);
    public int deleteGoods(int[] idArr);


}
