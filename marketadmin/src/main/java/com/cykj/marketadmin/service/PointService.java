package com.cykj.marketadmin.service;



import com.cykj.marketpojo.LayData;

import java.util.HashMap;
import java.util.List;

public interface PointService {
    public LayData findPointList(HashMap<String, Object> condition);
    public List<String> findPointState();
}
