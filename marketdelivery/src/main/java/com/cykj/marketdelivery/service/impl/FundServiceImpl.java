package com.cykj.marketdelivery.service.impl;

import com.cykj.marketdelivery.mapper.FundMapper;
import com.cykj.marketdelivery.mapper.User1Mapper;
import com.cykj.marketdelivery.service.FundService;
import com.cykj.marketpojo.DeliverymanFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fundService")
public class FundServiceImpl implements FundService {

    @Autowired
    private FundMapper fundMapper;

    @Override
    public int getCapital(Integer id,Integer type) {
        return fundMapper.getCapital(id,type);
    }

    @Override
    public List<DeliverymanFund> getMonthCapital(Integer id) {
        return fundMapper.getMonthCapital(id);
    }

    @Override
    public List<DeliverymanFund> getWithdrawal(Integer id) {
        return fundMapper.getWithdrawal(id);
    }

    @Override
    public List<DeliverymanFund> getDayCapital(Integer id) {
        return fundMapper.getDayCapital(id);
    }

    @Override
    public List<DeliverymanFund> getLastDayCapital(Integer id) {
        return fundMapper.getLastDayCapital(id);
    }


}
