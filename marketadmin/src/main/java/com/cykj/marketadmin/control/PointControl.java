package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.PointService;
import com.cykj.marketpojo.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("pointControl")
public class PointControl {
    @Autowired
    private PointService pointService;
//    查询积分列表
    @RequestMapping(value = "/findPointList")
    @ResponseBody
    public String findPointList(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        HashMap<String, Object> condition = new HashMap<>();
        String userId = request.getParameter("userId");
        if (userId != null && !userId.trim().equals("")) {
            condition.put("userId", userId);
        }
        String userName = request.getParameter("userName");
        if (userName != null && !userName.trim().equals("")) {
            condition.put("userName", userName);
        }
        String stateStr = request.getParameter("stateStr");
        if (stateStr != null && !stateStr.trim().equals("")) {
            condition.put("stateStr", stateStr);
        }
        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        int start = (pageNum - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        condition.put("start", start);
        condition.put("pageSize", pageSize);
        LayData layuiData = new LayData();
        layuiData = pointService.findPointList(condition);
        return JSON.toJSONString(layuiData);
    }
//    查询积分状态
    @RequestMapping(value = "/findPointState")
    @ResponseBody
    public String findPointState(HttpServletRequest request, HttpServletResponse response) {
        List<String> pointList= pointService.findPointState();
        return JSON.toJSONString(pointList);
    }
}
