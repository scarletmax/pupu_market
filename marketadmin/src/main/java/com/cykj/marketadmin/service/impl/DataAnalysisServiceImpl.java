package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.AdminMapper;
import com.cykj.marketadmin.mapper.DataAnalysisMapper;
import com.cykj.marketadmin.service.DataAnalysisService;
import com.cykj.marketpojo.DataAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

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
}
