package com.cykj.marketadmin.service;



import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.LogInfo;

import java.util.HashMap;

public interface LogService {
    Integer insertLog(LogInfo logInfo);
    LayData<LogInfo> showTable(HashMap<String,Object> condition);

}
