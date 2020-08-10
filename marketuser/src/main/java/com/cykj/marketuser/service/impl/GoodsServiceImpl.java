package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Goods;
import com.cykj.marketuser.mapper.GoodsMapper;
import com.cykj.marketuser.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public Goods goodsDetail(Integer id) {
        return null;
    }

    @Override
    public List<Goods> getGoodsListByType(int shopId, int typeId) {
        return goodsMapper.getGoodsListByType(shopId,typeId);
    }

    @Override
    public Goods queryGoodsDetail(int id) {
        Goods goods=goodsMapper.queryGoodsDetail(id);
        List<String> imgList=new ArrayList<>();
        imgList.add(goods.getPic1());
        imgList.add(goods.getPic2());
        imgList.add(goods.getPic3());
        imgList.add(goods.getPic4());
        goods.setImgList(imgList);
        goods.setGoodsComment(goodsMapper.queryOneComment(id));
        return goods;
    }
}
