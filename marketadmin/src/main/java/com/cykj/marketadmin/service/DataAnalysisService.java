package com.cykj.marketadmin.service;

import com.cykj.marketpojo.DataAnalysis;

import java.util.ArrayList;
import java.util.HashMap;

public interface DataAnalysisService {
    public ArrayList<DataAnalysis> findOrderAddress(HashMap<String, Object> condition);
}
