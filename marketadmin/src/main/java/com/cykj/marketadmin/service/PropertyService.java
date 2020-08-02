package com.cykj.marketadmin.service;

import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Property;

import java.util.HashMap;

public interface PropertyService {

    LayData<Property> findProperty(HashMap<String, Object> hashMap);
    int findCount(HashMap<String, Object> hashMap);
    int changeProperty(HashMap<String, Object> hashMap);
}
