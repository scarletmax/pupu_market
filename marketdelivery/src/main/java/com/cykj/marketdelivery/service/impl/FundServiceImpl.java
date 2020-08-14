package com.cykj.marketdelivery.service.impl;

import com.cykj.marketdelivery.mapper.FundMapper;
import com.cykj.marketdelivery.mapper.User1Mapper;
import com.cykj.marketdelivery.service.FundService;
import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.DeliverymanFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("fundService")
public class FundServiceImpl implements FundService {

    @Autowired
    private FundMapper fundMapper;

    @Autowired
    private UserMapper userMapper;

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

    @Override
    @Transactional
    public int addWithdraw(Integer id, Double money) {
        Deliveryman deliveryman=userMapper.getUserInfo(id);
        Double myMoney=deliveryman.getMoney();
        if (myMoney>money){
            myMoney-=money;
            deliveryman.setMoney(myMoney);
            deliveryman.setId(id);
            int res=userMapper.updateMoney(deliveryman);
            if (res>0){
                String serial=new Date().getTime()+""+id;
                DeliverymanFund deliverymanFund=new DeliverymanFund();
                deliverymanFund.setDeliverymanId(id);
                deliverymanFund.setIncome(money);
                deliverymanFund.setSerial(serial);
                return fundMapper.addWithdraw(deliverymanFund);
            }else{
                return 0;
            }

        }else{
            return 0;
        }

    }


}
