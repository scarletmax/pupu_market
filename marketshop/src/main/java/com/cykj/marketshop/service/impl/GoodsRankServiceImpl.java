package com.cykj.marketshop.service.impl;


import com.cykj.marketpojo.GoodsRank;
import com.cykj.marketshop.mapper.GoodsRankMapper;
import com.cykj.marketshop.service.GoodsRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsRankServiceImpl implements GoodsRankService {

    @Autowired
    private GoodsRankMapper goodsRankMapper;
    @Override
    public List<GoodsRank> findGoodsRank(HashMap<String, Object> hashMap) {
        return goodsRankMapper.findGoodsRank(hashMap);
    }

    @Override
    public List<GoodsRank> findGoodsRank2(HashMap<String, Object> hashMap) {
        return goodsRankMapper.findGoodsRank2(hashMap);
    }
}
