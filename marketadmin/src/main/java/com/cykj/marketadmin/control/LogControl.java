package com.cykj.marketadmin.control;


import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.LogService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/logControl")
public class LogControl {
    @Autowired
    LogService logService;
    @RequestMapping("/showTable")
    @ResponseBody
//    @Log(operationType = "查看",operationName = "")
    //获取文件分页数据
    public String showTable(HttpServletRequest request) {
        int curPage;
        if (request.getParameter("page") != null) {
            curPage = Integer.parseInt(request.getParameter("page"));
        } else {
            curPage = 1;
        }
        HashMap<String, Object> condition = new HashMap<>();
        String type = request.getParameter("type");
        if (type != null && !type.trim().equals("")) {
            condition.put("type", type);
        }
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
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
        Integer pageSize = Integer.parseInt(request.getParameter("limit"));
        condition.put("pageSize", pageSize);
        condition.put("startNum", (curPage - 1) * pageSize);
        LayData<LogInfo> logInfoLayData = logService.showTable(condition);
        return JSON.toJSONString(logInfoLayData);
    }
}
