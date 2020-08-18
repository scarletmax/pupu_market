package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Receiver;
import com.cykj.marketuser.mapper.ReceiverMapper;
import com.cykj.marketuser.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("receiverService")
public class ReceiverServiceImpl implements ReceiverService {
    @Autowired
    private ReceiverMapper receiverMapper;
    @Override
    public List<Receiver> getAllAddr(int userId) {
        return receiverMapper.getAllAddr(userId);
    }

    @Override
    public String editAddr(Receiver receiver) {
        if(receiver.getIsDefault()==1){
            receiverMapper.cancelAll(receiver);
        }else {
            receiver.setIsDefault(1);
        }
        return  receiverMapper.editAddr(receiver)>0 ? "success" : "fail";
    }

    @Override
    public String addAddr(Receiver receiver) {
        receiverMapper.cancelAll(receiver);

        return receiverMapper.addAddr(receiver)>0 ?"success" : "fail";
    }
}
