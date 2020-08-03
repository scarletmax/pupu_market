package com.cykj.marketadmin.mapper;


import com.cykj.marketpojo.LogInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface LogMapper {
//    插入日志
     Integer insertLog(LogInfo log);
     //获取日志列表
     List<LogInfo> getLogRecords(HashMap<String, Object> hashMap);
     //获取总量
     Integer getLogCount(HashMap<String, Object> hashMap);
}
