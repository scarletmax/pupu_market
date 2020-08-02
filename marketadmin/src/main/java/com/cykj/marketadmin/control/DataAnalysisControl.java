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

@RestController
@RequestMapping("dataAnalysisControl")
public class DataAnalysisControl {
    @Autowired
    private DataAnalysisService dataAnalysisService;

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

}

