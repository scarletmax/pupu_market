package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.User;
import com.cykj.marketuser.mapper.GoodsMapper;
import com.cykj.marketuser.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<Goods> getGoodsListByParentType(int shopId, int typeId) {
        return goodsMapper.getGoodsListByParentType(shopId,typeId);
    }

    @Override
    public List<Goods> queryGoods(int shopId, String name) {
        return goodsMapper.queryGoods(shopId,name);
    }

    @Override
    @Transactional
    public String buy(String orderNum) {
        //获得所有购买的商品
        List<Goods> goodsList= goodsMapper.getGoodsByOrderNum(orderNum);
        //更改订单状态
        goodsMapper.buy(orderNum);
        //扣除商品数量
        boolean flag=true;
        for (int i = 0; i <goodsList.size(); i++) {
            int id=goodsList.get(i).getId();
            int version =goodsList.get(i).getVersion();
            int totalCount=goodsList.get(i).getTotalCount();
            int goodsCount=goodsList.get(i).getGoodsCount();
            if(totalCount>goodsCount){
                goodsMapper.delGoodsCount(id,goodsCount,version);
            }else {
                flag=false;
            }
        }
        //加积分
        int userId= goodsList.get(0).getUserId();

        if(flag){
           double totalPrice =goodsList.get(0).getTotalPrice();
           int point=(int)(totalPrice/10);
           goodsMapper.addPoint(userId,point);
       }
        //查询当前等级
        User user= goodsMapper.queryUser(userId);
        int levelId= user.getLevelId();
        int point =user.getPoint();
        //加分后id
        int curId=goodsMapper.queryCurrLevel(point);
        if(levelId!=curId){
            return "upgrade";
        }else {
            return flag?"success":"fail";
        }


    }
}
