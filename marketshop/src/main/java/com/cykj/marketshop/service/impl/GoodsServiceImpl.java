package com.cykj.marketshop.service.impl;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Album;
import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Photo;
import com.cykj.marketshop.mapper.GoodsMapper;
import com.cykj.marketshop.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    public LayData<Goods> searchGoodsList(HashMap<String,Object> condition){
        LayData<Goods> layData = new LayData<>();
        layData.setCount(goodsMapper.selectGoodsNum(condition));
        List<Goods> goodsList= goodsMapper.selectGoodsList(condition);
        for (Goods goods:goodsList) {
            Photo[] photos = {
                    new Photo("图片1",0,goods.getPic1(),null),
                    new Photo("图片2",1,goods.getPic2(),null),
                    new Photo("图片3",2,goods.getPic3(),null),
                    new Photo("图片4",3,goods.getPic4(),null)
            };
            Album album=new Album(goods.getName(),0,0,photos);
            goods.setAlbum(album);
        }
        layData.setData(goodsList);
        return layData;
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

}
