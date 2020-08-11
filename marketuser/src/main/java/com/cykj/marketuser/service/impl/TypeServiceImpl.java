package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Type;
import com.cykj.marketuser.mapper.TypeMapper;
import com.cykj.marketuser.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }
}
