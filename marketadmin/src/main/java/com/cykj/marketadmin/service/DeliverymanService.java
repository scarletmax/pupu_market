package com.cykj.marketadmin.service;


import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.LayData;

import java.util.HashMap;
import java.util.List;

public interface DeliverymanService {
    LayData<Deliveryman> showTable(HashMap<String, Object> condition);
    //审核派送员
    boolean updateState(int id, String state);
    //获取所有派送员状态
    List<String> getAllState();
    double queryBenefit();
    String setBenefit(String benefit);

}
