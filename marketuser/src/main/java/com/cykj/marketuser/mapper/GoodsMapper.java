package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.GoodsComment;
import com.cykj.marketpojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    //查询商品信息
    Goods queryGoodsDetail(int id);
    //根据类型查询商品
    List<Goods> getGoodsListByType(@Param("shopId") int shopId, @Param("typeId") int typeId);
    //获取商品的一条评论
    GoodsComment queryOneComment(int id);
    List<Goods> getGoodsListByParentType(@Param("shopId") int shopId, @Param("typeId") int typeId);
    List<Goods> queryGoods(@Param("shopId")int shopId,@Param("name")String name);
    List<Goods> getGoodsByOrderNum(String orderNum);
    Integer buy(String orderNum);
    Integer delGoodsCount(@Param("id")int id,@Param("goodsCount")int goodsCount,@Param("version")int version);
    Integer addPoint(@Param("id")int id,@Param("point")int point);
    User queryUser(@Param("id")int id);
    Integer queryCurrLevel(int point);

}
