package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.GoodsTypeRank;
import com.cykj.marketshop.mapper.GoodsTypeRankMapper;
import com.cykj.marketshop.service.GoodsTypeRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsTypeRankServiceImpl implements GoodsTypeRankService {

    @Autowired
    private GoodsTypeRankMapper goodsTypeRankMapper;

    @Override
    public List<GoodsTypeRank> findGoodsTypeRank(HashMap<String, Object> hashMap) {
        return goodsTypeRankMapper.findGoodsTypeRank(hashMap);
    }
}
