package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.FlashSale;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FlashSaleMapper {

    public FlashSaleMapper showFlashByGoodsId(String id);

    public int selectNum();
    public int selectFlashSaleNum(HashMap<String, Object> condition);
    public List<FlashSale> selectFlashSaleList(HashMap<String, Object> condition);

    public int insertFlashSale(FlashSale flashSale);
    public int returnCount(int id);


}
