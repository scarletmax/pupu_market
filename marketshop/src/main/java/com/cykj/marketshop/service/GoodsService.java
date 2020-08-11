package com.cykj.marketshop.service;


import com.cykj.marketpojo.*;

import java.util.HashMap;

public interface GoodsService {

    public LayData<Goods> searchGoodsList(HashMap<String, Object> condition);
    public Album detailPic(String id);
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

    public int reduceGoodsNum(int num,int id);
}
