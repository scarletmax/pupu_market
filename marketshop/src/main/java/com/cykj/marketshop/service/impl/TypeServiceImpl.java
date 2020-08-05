package com.cykj.marketshop.service.impl;

import com.cykj.marketpojo.Type;
import com.cykj.marketshop.mapper.TypeMapper;
import com.cykj.marketshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> parentTypeList() {
        return typeMapper.parentTypeList();
    }

    @Override
    public List<Type> typeList(String parentTypeId) {
        return typeMapper.typeList(parentTypeId);
    }


}
