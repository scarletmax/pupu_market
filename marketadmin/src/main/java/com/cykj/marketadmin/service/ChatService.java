package com.cykj.marketadmin.service;

import com.cykj.marketadmin.webSocket.ChatSaveAcc;
import com.cykj.marketadmin.webSocket.Msg;

import java.util.HashMap;
import java.util.List;

public interface ChatService {
    List<Msg> findChatMsg(HashMap<String, Object> hashMap);

    //    int insertChatMsg(Msg msg);
    /*先验证后插入*/
    int insertSaveAcc(HashMap<String, Object> hashMap);


    //查询客服最近五天的聊天人员
    List<ChatSaveAcc> findSaveAcc(HashMap<String, Object> hashMap);
}
