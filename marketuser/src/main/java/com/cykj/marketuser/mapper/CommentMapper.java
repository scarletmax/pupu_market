package com.cykj.marketuser.mapper;
import com.cykj.marketpojo.DeliverymanComment;
import com.cykj.marketpojo.GoodsComment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CommentMapper {

    public int insertDC(DeliverymanComment deliverymanComment);

    public int insertGC(GoodsComment goodsComment);
}
