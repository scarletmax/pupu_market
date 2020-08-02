package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.PropertyMapper;
import com.cykj.marketadmin.service.PropertyService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;



    @Override
    public LayData<Property> findProperty(HashMap<String, Object> hashMap) {
        LayData<Property> layData = new LayData<>();
        List<Property> list = propertyMapper.findProperty(hashMap);
        int total = propertyMapper.findCount(hashMap);
        layData.setData(list);
        layData.setCount(total);
        layData.setMsg("");
        return layData;
    }

    @Override
    public int findCount(HashMap<String, Object> hashMap) {
        return propertyMapper.findCount(hashMap);
    }

    @Override
    public int changeProperty(HashMap<String, Object> hashMap) {
        return propertyMapper.changeProperty(hashMap);
    }
}
