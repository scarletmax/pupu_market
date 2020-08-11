package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Advertisement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShowAdvertismentMapper {

    List<Advertisement> findCarouselAD();
    List<Advertisement> findStaticAD();
}
