package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.LogMapper;
import com.cykj.marketadmin.service.LogService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public Integer insertLog(LogInfo logInfo) {
        return logMapper.insertLog(logInfo);
    }
    @Override
    public LayData<LogInfo> showTable(HashMap<String, Object> condition) {
        List<LogInfo> logInfoList = null;
        int totalCount = 0;
        logInfoList = logMapper.getLogRecords(condition);
        totalCount = logMapper.getLogCount(condition);
        LayData<LogInfo> logInfoLayData = new LayData<>(0, "", totalCount, logInfoList);
        return logInfoLayData;
    }
}
