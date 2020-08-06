package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Property;
import com.cykj.marketshop.mapper.PropertyMapper;
import com.cykj.marketshop.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("propertyService")
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public List<Property> enumGoodsState() {
        return propertyMapper.enumGoodsState();
    }
}
