package com.cykj.marketadmin.service;



import com.cykj.marketpojo.LayData;

import java.util.HashMap;

public interface LevelService {
    public LayData findLevelList(HashMap<String, Object> condition);
}