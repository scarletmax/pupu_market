package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.AdminMapper;
import com.cykj.marketadmin.mapper.DataAnalysisMapper;
import com.cykj.marketadmin.service.DataAnalysisService;
import com.cykj.marketpojo.DataAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("dataAnalysisService")
public class DataAnalysisServiceImpl implements DataAnalysisService {
    @Autowired
    DataAnalysisMapper dataAnalysisMapper;
    @Override
    public ArrayList<DataAnalysis> findOrderAddress(HashMap<String, Object> condition) {
        return dataAnalysisMapper.findOrderAddress(condition);
    }
    @Override
    public ArrayList<DataAnalysis> findOrderTime(HashMap<String, Object> condition) {
        return dataAnalysisMapper.findOrderTime(condition);
    }
    /**    王子默部分   **/
    //  获取本周的订单量详情
    @Override
    public List<DataAnalysis> getOrderNumByWeek() {
        return dataAnalysisMapper.getOrderNumByWeek();
    }
    //  获取本月的订单量详情
    @Override
    public List<DataAnalysis> getOrderNumByMonth() {
        return dataAnalysisMapper.getOrderNumByMonth();
    }
    //获取本年度的订单量详情
    @Override
    public List<DataAnalysis> getOrderNumByYear() {
        return dataAnalysisMapper.getOrderNumByYear();
    }

}
