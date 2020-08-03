package com.cykj.marketadmin.service;

import com.cykj.marketpojo.DataAnalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DataAnalysisService {
    public ArrayList<DataAnalysis> findOrderAddress(HashMap<String, Object> condition);
    public ArrayList<DataAnalysis> findOrderTime(HashMap<String, Object> condition);

    /**    王子默部分   **/
    //  获取本周的订单量详情
    List<DataAnalysis> getOrderNumByWeek();
    //  获取本月的订单量详情
    List<DataAnalysis> getOrderNumByMonth();
    //获取本年度的订单量详情
    List<DataAnalysis> getOrderNumByYear();
}
