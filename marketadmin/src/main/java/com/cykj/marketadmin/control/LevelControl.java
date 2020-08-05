package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.LevelService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("levelControl")
public class LevelControl {
    @Autowired
    private LevelService levelService;

    @RequestMapping(value = "/findLevelList")
    @ResponseBody
    public String findLevelList(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        HashMap<String, Object> condition = new HashMap<>();
        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        int start = (pageNum - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        condition.put("start", start);
        condition.put("pageSize", pageSize);
        LayData layuiData = new LayData();
        layuiData = levelService.findLevelList(condition);
        return JSON.toJSONString(layuiData);
    }

    @RequestMapping(value = "/addLevel")
    @ResponseBody
    public String addLevel(HttpServletRequest request, HttpServletResponse response) {
        String levelInfo = request.getParameter("levelInfo");
        Level level = JSON.parseObject(levelInfo, Level.class);
        int a = 0;

        a = levelService.addLevel(level);
        if (a == 1) {
            return "success";
        } else {
            return "fail";
        }
    }


}
