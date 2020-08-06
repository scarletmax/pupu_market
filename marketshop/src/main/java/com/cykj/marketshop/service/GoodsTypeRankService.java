package com.cykj.marketshop.service;

import com.cykj.marketpojo.GoodsTypeRank;

import java.util.HashMap;
import java.util.List;

public interface GoodsTypeRankService {
    List<GoodsTypeRank> findGoodsTypeRank(HashMap<String,Object> hashMap);
}
