package com.cykj.marketadmin.service.impl;

import com.cykj.marketadmin.mapper.ChatMapper;
import com.cykj.marketadmin.service.ChatService;
import com.cykj.marketadmin.webSocket.ChatSaveAcc;
import com.cykj.marketadmin.webSocket.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<Msg> findChatMsg(HashMap<String, Object> hashMap) {

        return chatMapper.findChatMsg(hashMap);
    }

    @Override
    public int insertSaveAcc(HashMap<String, Object> hashMap) {//保存当前聊天人员
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        int b=0;
        Date date = new Date();
        System.out.println(formatter.format(date));
        hashMap.put("createTime",formatter.format(date));
        int a=chatMapper.verifySaveAcc(hashMap);
        if(a<1){
           b=chatMapper.insertSaveAcc(hashMap);
        }

        return b;
    }


    @Override
    public List<ChatSaveAcc> findSaveAcc(HashMap<String, Object> hashMap) {
        return chatMapper.findSaveAcc(hashMap);
    }

//    @Override
//    public int insertChatMsg(Msg msg) {
//
//        return chatService.insertChatMsg(msg);
//    }
}
