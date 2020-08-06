package com.cykj.marketshop.service;

import com.cykj.marketpojo.Advertisement;
import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.LayData;

import java.util.HashMap;
import java.util.List;

public interface AdService {
    LayData<Advertisement> showTable(HashMap<String, Object> condition);
    List<String> getAllType();
    String updateState(int id,int state,int shopId);
    Integer updateAd(Advertisement ad);
    Integer newAd(Advertisement ad);

}
