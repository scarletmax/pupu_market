package com.cykj.marketadmin.service.impl;


import com.cykj.marketadmin.mapper.DeliverymanMapper;
import com.cykj.marketadmin.service.DeliverymanService;
import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("deliverymanService")
public class DeliverymanServiceImpl implements DeliverymanService {
    @Autowired
    private DeliverymanMapper deliverymanMapper;

    @Override
    public LayData<Deliveryman> showTable(HashMap<String, Object> condition) {
        List<Deliveryman> deliverymanList = deliverymanMapper.queryDeliveryman(condition);
        int totalCount = deliverymanMapper.queryCount(condition);
        return new LayData<Deliveryman>(0, "", totalCount, deliverymanList);

    }

    @Override
    public boolean updateState(int id, String state) {
            int result = 0;
            //更新派送员状态
            result = deliverymanMapper.updateState(id, state);
            return result > 0;

    }

    @Override
    public List<String> getAllState() {
        return deliverymanMapper.getAllState();
    }
}
