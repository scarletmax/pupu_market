package com.cykj.marketshop.service.impl;


import com.cykj.marketpojo.FlashSale;
import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.LayData;
import com.cykj.marketshop.mapper.FlashSaleMapper;
import com.cykj.marketshop.mapper.GoodsMapper;
import com.cykj.marketshop.service.FlashSaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("flashSaleService")
public class FlashSaleServiceImpl implements FlashSaleService {

    @Resource
    private FlashSaleMapper flashSaleMapper;
    @Resource
    private GoodsMapper goodsMapper;


    @Override
    public LayData<FlashSale> selectFlashSale(HashMap<String, Object> condition) {
        LayData<FlashSale> layData = new LayData<FlashSale>();
        layData.setCount(flashSaleMapper.selectFlashSaleNum(condition));
        layData.setData(flashSaleMapper.selectFlashSaleList(condition));
        return layData;
    }

    //从总库存中减去用于秒杀的库存
    @Override
    public int insertFlashSale(FlashSale flashSale) {
        int a = flashSaleMapper.insertFlashSale(flashSale);

        //能否回滚方法里的数据库操作？？
        return a;
    }
}
