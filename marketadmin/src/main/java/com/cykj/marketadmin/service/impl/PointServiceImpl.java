package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.PointMapper;
import com.cykj.marketadmin.service.PointService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("pointService")
public class PointServiceImpl implements PointService {
    @Autowired
    PointMapper pointMapper;

    @Override
    public LayData findPointList(HashMap<String, Object> condition) {
        LayData layuiData = new LayData();
        List<Point> pointList = pointMapper.findPointList(condition);
        int count = pointMapper.findPointCount(condition);
        if (pointList.size() > 0) {
            layuiData.setCode(0);
            layuiData.setMsg("");
            layuiData.setCount(count);
            layuiData.setData(pointList);
        } else {
            layuiData.setCode(1);
            layuiData.setMsg("加载失败");
        }
        return layuiData;
    }

    @Override
    public List<String> findPointState() {
        List<String> pointList = null;
        pointList = pointMapper.findPointState();
        return pointList;
    }
}
