package com.cykj.marketadmin.mapper;

import com.cykj.marketpojo.DataAnalysis;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface DataAnalysisMapper {
    ArrayList<DataAnalysis> findOrderAddress(HashMap<String, Object> condition);
    ArrayList<DataAnalysis> findOrderTime(HashMap<String, Object> condition);
}
