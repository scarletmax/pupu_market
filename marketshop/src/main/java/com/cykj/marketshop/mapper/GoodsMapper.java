package com.cykj.marketshop.mapper;


import com.cykj.marketpojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GoodsMapper {

    public int selectGoodsNum(HashMap<String, Object> condition);
    public List<Goods> selectGoodsList(HashMap<String, Object> condition);
    public Goods detailPic(String id);
    public int startRecommended(String id);
    public int endRecommended(String id);
    public int startSpecial(String id);
    public int endSpecial(String id);
    public int startFlashSale(String id);
    public int endFlashSale(String id);
    public int putaway(int[] idArr);
    public int unshelve(int[] idArr);
    public int deleteGoods(int[] idArr);
    public int addGoods(Goods goods);
    public int editGoods(Goods goods);

    public int reduceCount(int goodsId, int restCount);
    public int searchCount(int goodsId);
    public int returnCount(int id,int restCount);



}
