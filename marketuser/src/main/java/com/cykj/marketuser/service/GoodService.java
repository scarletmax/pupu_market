package com.cykj.marketuser.service;

import java.util.List;
import com.cykj.marketpojo.Goods;

public interface GoodService {
    public List<Goods> getSpecialGood(int shopId);
    public List<Goods> getHighSaleGood(int shopId);
    public List<Goods> getRecommendedGood(int shopId);
}
