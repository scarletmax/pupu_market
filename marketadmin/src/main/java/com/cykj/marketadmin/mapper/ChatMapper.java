package com.cykj.marketadmin.mapper;

import com.cykj.marketadmin.webSocket.ChatSaveAcc;
import com.cykj.marketadmin.webSocket.Msg;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ChatMapper {

    List<Msg>  findChatMsg(HashMap<String, Object> hashMap);
//    int insertChatMsg(Msg msg);
    /*先验证后插入*/
    int insertSaveAcc(HashMap<String, Object> hashMap);
    //验证今天是否保存该用户
    int verifySaveAcc(HashMap<String, Object> hashMap);
    //查询客服最近五天的聊天人员
    List<ChatSaveAcc> findSaveAcc(HashMap<String, Object> hashMap);
}
