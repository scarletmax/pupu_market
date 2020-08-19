package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Marker;
import com.cykj.marketpojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@Mapper
public interface ShopMapper {
    List<Shop> getShops(@Param("longitude")String longitude, @Param("latitude")String latitude);
    List<Marker> getAllShopMarkers();
}
