package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Goods;
import com.cykj.marketuser.mapper.SpecialGoodsMapper;
import com.cykj.marketuser.service.SpecialGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialGoodsServiceImpl implements SpecialGoodsService {

    @Autowired
    private SpecialGoodsMapper specialGoodsMapper;

    @Override
    public List<Goods> findSpecialGoods() {
        return specialGoodsMapper.findSpecialGoods();
    }
}
