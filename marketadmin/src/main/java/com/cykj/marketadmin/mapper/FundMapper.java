package com.cykj.marketadmin.mapper;

import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.DeliverymanFund;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FundMapper {
    List<DeliverymanFund> findFundList();
    DeliverymanFund examine(int id, String state);
    int unExamine(int id, String state);
    double selectIncome(int id);
    double selectMoney(int id);
    int selectId(int id);
    int updateMoney(int deliverymanId, Double nowMoney);
    int updateState(String serial);
}
