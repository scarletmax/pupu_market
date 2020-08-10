package com.cykj.marketuser.service;

import com.cykj.marketpojo.Goods;

import java.util.List;

public interface GoodsService {
    /**
     王子默部分
     **/
    //查询商品详情
    Goods goodsDetail(Integer id);
    //查看商品列表
    List<Goods> getGoodsListByType(int shopId, int typeId);
    //查询商品信息
    Goods queryGoodsDetail(int id);


}
