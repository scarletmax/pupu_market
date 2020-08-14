package com.cykj.marketadmin.service;

import com.cykj.marketpojo.DeliverymanFund;
import com.cykj.marketpojo.LayData;

import java.util.HashMap;

public interface FundService {
    public LayData findFundList();
    public DeliverymanFund  examine(int id, String state);
    public boolean unExamine(int id, String state);
    public  int updateState(String serial);
}
