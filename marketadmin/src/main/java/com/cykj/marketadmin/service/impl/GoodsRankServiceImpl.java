package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.GoodsMapper;
import com.cykj.marketadmin.mapper.GoodsRankMapper;
import com.cykj.marketadmin.service.GoodsRankService;
import com.cykj.marketpojo.GoodsRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
