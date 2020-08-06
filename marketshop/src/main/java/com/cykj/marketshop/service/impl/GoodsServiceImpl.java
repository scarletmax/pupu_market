package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.*;
import com.cykj.marketshop.mapper.GoodsMapper;
import com.cykj.marketshop.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    public LayData<Goods> searchGoodsList(HashMap<String,Object> condition){
        LayData<Goods> layData = new LayData<Goods>();
        layData.setCount(goodsMapper.selectGoodsNum(condition));
        List<Goods> goodsList= goodsMapper.selectGoodsList(condition);
        layData.setData(goodsList);
        return layData;
    }

    @Override
    public Album detailPic(String id) {
        Goods goods = goodsMapper.detailPic(id);
        Photo[] photos = {
                new Photo("图片1",0,goods.getPic1(),null),
                new Photo("图片2",0,goods.getPic2(),null),
                new Photo("图片3",0,goods.getPic3(),null),
                new Photo("图片4",0,goods.getPic4(),null),
        };
        return new Album(goods.getName(),0,0,photos);
    }

    @Override
    public int startRecommended(String id) {
        return goodsMapper.startRecommended(id);
    }

    @Override
    public int endRecommended(String id) {
        return goodsMapper.endRecommended(id);
    }

    @Override
    public int startSpecial(String id) {
        return goodsMapper.startSpecial(id);
    }

    @Override
    public int endSpecial(String id) {
        return goodsMapper.endSpecial(id);
    }

    @Override
    public int startFlashSale(String id) {
        return goodsMapper.startFlashSale(id);
    }

    @Override
    public int endFlashSale(String id) {
        return goodsMapper.endFlashSale(id);
    }

    @Override
    public int putaway(int[] idArr) {
        return goodsMapper.putaway(idArr);
    }

    @Override
    public int unshelve(int[] idArr) {
        return goodsMapper.unshelve(idArr);
    }

    @Override
    public int deleteGoods(int[] idArr) {
        return goodsMapper.deleteGoods(idArr);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int editGoods(Goods goods) {
        return goodsMapper.editGoods(goods);
    }


}
