package com.cykj.marketshop.service;


import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.LayData;

import java.util.HashMap;

public interface GoodsService {

    public LayData<Goods> searchGoodsList(HashMap<String, Object> condition);
    public int startRecommended(String id);
    public int endRecommended(String id);
    public int startSpecial(String id);
    public int endSpecial(String id);
    public int putaway(int[] idArr);
    public int unshelve(int[] idArr);
    public int deleteGoods(int[] idArr);
}
