package com.cykj.marketdelivery.mapper;

import com.cykj.marketpojo.DeliverymanFund;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundMapper {
    int getCapital(Integer id,Integer type);
    List<DeliverymanFund> getMonthCapital(Integer id);
    List<DeliverymanFund> getWithdrawal(Integer id);
    List<DeliverymanFund> getDayCapital(Integer id);
    List<DeliverymanFund> getLastDayCapital(Integer id);
}
