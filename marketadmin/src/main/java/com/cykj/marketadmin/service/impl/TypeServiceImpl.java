package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.TypeMapper;
import com.cykj.marketadmin.service.TypeService;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Override
    public LayData<Type> searchTypeList(HashMap<String, Object> condition) {
        LayData<Type> layData = new LayData<Type>();
        layData.setCount(typeMapper.selectTypeNum(condition));
        layData.setData(typeMapper.selectTypeList(condition));
        return layData;
    }

    @Override
    public int editType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insertType(type);
    }

    @Override
    public int removeType(String id) {
        return typeMapper.deleteType(id);
    }

    @Override
    public int isTypeRepeat(String name) {
        return typeMapper.isTypeRepeat(name);
    }
}
