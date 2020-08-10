package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.GoodsComment;
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
}
