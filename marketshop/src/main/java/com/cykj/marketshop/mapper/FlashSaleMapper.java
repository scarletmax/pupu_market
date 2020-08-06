package com.cykj.marketshop.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FlashSaleMapper {

    public FlashSaleMapper showFlashByGoodsId(String id);


}
