package com.cykj.marketdelivery.service;

import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.DeliverymanFund;

import java.util.List;

public interface FundService {
    public int getCapital(Integer id,Integer type);
    public List<DeliverymanFund> getMonthCapital(Integer id);
    public List<DeliverymanFund> getWithdrawal(Integer id);
    public List<DeliverymanFund> getDayCapital(Integer id);
    public List<DeliverymanFund> getLastDayCapital(Integer id);
}
