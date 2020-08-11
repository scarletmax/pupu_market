package com.cykj.marketuser.service.impl;

import com.cykj.marketuser.mapper.GoodMapper;
import com.cykj.marketuser.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import com.cykj.marketpojo.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodService")
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Goods> getSpecialGood(int shopId) {
        return goodMapper.getSpecialGood(shopId);
    }

    @Override
    public List<Goods> getMoreSpecialGood(int shopId) {
        return goodMapper.getMoreSpecialGood(shopId);
    }


    @Override
    public List<Goods> getHighSaleGood(int shopId) {
        return goodMapper.getHighSaleGood(shopId);
    }

    @Override
    public List<Goods> getRecommendedGood(int shopId) {
        return goodMapper.getRecommendedGood(shopId);
    }

    @Override
    public List<Goods> findNewGoods(int shopId) {
        return goodMapper.findNewGoods(shopId);
    }

    @Override
    public List<Goods> findMoreNewGoods(int shopId) {
        return goodMapper.findMoreNewGoods(shopId);
    }


}
