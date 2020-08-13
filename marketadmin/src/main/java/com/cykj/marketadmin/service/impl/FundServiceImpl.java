package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.FundMapper;
import com.cykj.marketadmin.mapper.GoodsCommentMapper;
import com.cykj.marketadmin.service.FundService;
import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.DeliverymanFund;
import com.cykj.marketpojo.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FundServiceImpl implements FundService {
    @Autowired
    private FundMapper fundMapper;



    @Override
    public LayData findFundList() {
        LayData layuiData = new LayData();
        List<DeliverymanFund> fundList=fundMapper.findFundList();
        if (fundList.size() > 0) {
            layuiData.setCode(0);
            layuiData.setMsg("");
//            layuiData.setCount(count);
            layuiData.setData(fundList);
        } else {
            layuiData.setCode(1);
            layuiData.setMsg("加载失败");
        }
        return layuiData;
    }

    @Override
    public DeliverymanFund examine(int id, String state) {
        DeliverymanFund deliverymanFund=fundMapper.examine(id, state);
        return deliverymanFund;
    }

    @Override
    @Transactional
    public boolean unExamine(int id, String state) {
        int result = 0;
        //更新审核状态
        fundMapper.unExamine(id, state);
        Double withDraw=fundMapper.selectIncome(id);
        Double nowMoney=fundMapper.selectMoney(id);
        nowMoney+=withDraw;

        int deliverymanId=fundMapper.selectId(id);
        result=fundMapper.updateMoney(deliverymanId,nowMoney);
        return result > 0;
    }

    @Override
    public int updateState(String serial) {
        int result = 0;
        result=fundMapper.updateState(serial);
        return result ;
    }
}
