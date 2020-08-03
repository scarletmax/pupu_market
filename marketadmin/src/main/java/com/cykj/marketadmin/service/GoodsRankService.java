package com.cykj.marketadmin.service;

import com.cykj.marketpojo.GoodsRank;

import java.util.HashMap;
import java.util.List;

public interface GoodsRankService {
    List<GoodsRank> findGoodsRank(HashMap<String,Object> hashMap);
    List<GoodsRank> findGoodsRank2(HashMap<String,Object> hashMap);
}
