package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.AdminService;
import com.cykj.marketadmin.service.DataAnalysisService;
import com.cykj.marketpojo.DataAnalysis;
import com.cykj.marketpojo.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("dataAnalysisControl")
public class DataAnalysisControl {
    @Autowired
    private DataAnalysisService dataAnalysisService;
//    查询不同分店的订单信息
    @RequestMapping(value = "/findOrderAddress")
    @ResponseBody
    public String findOrderAddress(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> condition = new HashMap<>();
        String startDate = request.getParameter("startTime");
        String endDate = request.getParameter("endTime");
        if (startDate != null && !startDate.trim().equals("")) {
            condition.put("startDate", startDate);
        } else {
            startDate = "";
        }
        if (endDate != null && !endDate.trim().equals("")) {
            condition.put("endDate", endDate);
        } else {
            endDate = "";
        }
        ArrayList<DataAnalysis> dataAnalysisList = dataAnalysisService.findOrderAddress(condition);
        return JSON.toJSONString(dataAnalysisList);
    }
//    查询不同时间段的订单信息
    @RequestMapping(value = "/findOrderTime")
    @ResponseBody
    public String findOrderTime(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> condition = new HashMap<>();
        String selectDay = request.getParameter("selectDay");
        if (selectDay != null && !selectDay.trim().equals("")) {
            condition.put("selectDay", selectDay);
            condition.put("selectDayHour", selectDay + " 23");
        } else {
            selectDay = "";
        }
        ArrayList<DataAnalysis> dataAnalysisList = dataAnalysisService.findOrderTime(condition);
        return JSON.toJSONString(dataAnalysisList);
    }

    /**
     * 王子默部分
     **/
    @RequestMapping("getOrderNumByWeek")
    @ResponseBody
    //  获取本周的订单量详情
    public String getOrderNumByWeek() {
        return JSON.toJSONString(dataAnalysisService.getOrderNumByWeek());
    }
    @RequestMapping("getOrderNumByMonth")
    @ResponseBody
    //  获取本月的订单量详情
    public String getOrderNumByMonth() {
        return JSON.toJSONString(dataAnalysisService.getOrderNumByMonth());
    }
    @RequestMapping("getOrderNumByYear")
    @ResponseBody
    //获取本年度的订单量详情
    public String getOrderNumByYear() {
        return JSON.toJSONString(dataAnalysisService.getOrderNumByYear());
    }

}

