package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.GoodsMapper;
import com.cykj.marketadmin.service.GoodsService;
import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.LayData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    public LayData<Goods> searchGoodsList(HashMap<String,Object> condition){
        LayData<Goods> layData = new LayData<>();
        layData.setCount(goodsMapper.selectGoodsNum(condition));
        layData.setData(goodsMapper.selectGoodsList(condition));
        return layData;
    }

}
