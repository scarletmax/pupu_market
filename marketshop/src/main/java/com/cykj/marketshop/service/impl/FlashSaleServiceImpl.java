package com.cykj.marketshop.service.impl;


import com.cykj.marketshop.mapper.FlashSaleMapper;
import com.cykj.marketshop.service.FlashSaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("flashSaleService")
public class FlashSaleServiceImpl implements FlashSaleService {

    @Resource
    private FlashSaleMapper flashSaleMapper;


    @Override
    public FlashSaleMapper showFlashByGoodsId(String id) {
        return flashSaleMapper.showFlashByGoodsId(id);
    }
}
