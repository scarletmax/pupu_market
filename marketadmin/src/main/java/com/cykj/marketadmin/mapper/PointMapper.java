package com.cykj.marketadmin.mapper;

import com.cykj.marketpojo.Point;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PointMapper {
    List<Point> findPointList(HashMap<String, Object> condition);
    int  findPointCount(HashMap<String, Object> condition);
    List<String> findPointState();
}
