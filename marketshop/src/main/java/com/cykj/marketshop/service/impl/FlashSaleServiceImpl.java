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
    public int insertFlashSale(FlashSale flashSale) throws Exception{
        int a = flashSaleMapper.insertFlashSale(flashSale);
        int b = goodsMapper.reduceCount(flashSale.getGoodsId(),flashSale.getRestCount());
        System.out.println("扣除后查出来的数量是"+goodsMapper.searchCount(flashSale.getGoodsId()));
        if(goodsMapper.searchCount(flashSale.getGoodsId())<10){
            System.out.println("执行了throw");
           throw new Exception();
        }
        System.out.println("执行了throw后");
        if(a==1&&b==1){
            return 1;
        }
        return 0;//不会返回
    }

    @Override
    public int returnCount(int id, int restCount) throws Exception{
        int a = flashSaleMapper.returnCount(id);
        int b = goodsMapper.returnCount(id,restCount);
        if(a==1&&b==1){
            return 1;
        }
        return 0;//不会返回
    }
}
