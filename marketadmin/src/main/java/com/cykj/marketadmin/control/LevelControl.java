package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
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
//    查询等级列表
    @RequestMapping(value = "/findLevelList")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
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
//    添加新等级
    @RequestMapping(value = "/addLevel")
    @ResponseBody
    @Log(operationType = "查看",operationName = "添加等级配置")
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
//    修改等级
    @RequestMapping(value = "/editLevel")
    @ResponseBody
   @Log(operationType = "操作",operationName = "编辑等级")
    public String editLevel(HttpServletRequest request, HttpServletResponse response) {
        String levelInfo = request.getParameter("levelInfo");
        Level level = JSON.parseObject(levelInfo, Level.class);
        int a = 0;

        a = levelService.editLevel(level);
        if (a == 1) {
            return "success";
        } else {
            return "fail";
        }
    }
//    删除等级
    @RequestMapping(value = "/deleteLevel")
    @ResponseBody
    @Log(operationType = "操作",operationName = "删除等级")
    public String deleteLevel(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int a = 0;
        a = levelService.deleteLevel(id);
        if (a == 1) {
            return "success";
        } else {
            return "fail";
        }
    }


}
