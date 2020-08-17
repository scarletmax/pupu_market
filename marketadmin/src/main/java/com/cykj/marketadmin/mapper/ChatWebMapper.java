package com.cykj.marketadmin.mapper;

import com.cykj.marketadmin.webSocket.Msg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Scope;

@Mapper
public interface ChatWebMapper {

    int insertChatMsg(Msg msg);
}
