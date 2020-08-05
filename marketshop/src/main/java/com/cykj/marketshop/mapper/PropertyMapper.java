package com.cykj.marketshop.mapper;

import com.cykj.marketpojo.Property;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PropertyMapper {

     //枚举商品状态
     List<Property> enumGoodsState();
}
