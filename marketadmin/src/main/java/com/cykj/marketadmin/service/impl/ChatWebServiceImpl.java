package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.ChatWebMapper;
import com.cykj.marketadmin.service.ChatWebService;
import com.cykj.marketadmin.webSocket.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatWebServiceImpl implements ChatWebService {

    @Autowired
   private ChatWebMapper chatWebMapper;
    @Override
    public int insertChatMsg(Msg msg) {
//        int a=0;
        return chatWebMapper.insertChatMsg(msg);
    }
}
