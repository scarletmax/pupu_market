package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.LevelMapper;
import com.cykj.marketadmin.service.LevelService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("levelService")
public class LevelServiceImpl implements LevelService {

    @Autowired
    LevelMapper levelMapper;

    @Override
    public LayData findLevelList(HashMap<String, Object> condition) {
        LayData layuiData = new LayData();
        List<Level> levelList = levelMapper.findLevelList(condition);
        int count = levelMapper.findLevelCount(condition);
        if (levelList.size() > 0) {
            layuiData.setCode(0);
            layuiData.setMsg("");
            layuiData.setCount(count);
            layuiData.setData(levelList);
        } else {
            layuiData.setCode(1);
            layuiData.setMsg("加载失败");
        }
        return layuiData;
    }

}
