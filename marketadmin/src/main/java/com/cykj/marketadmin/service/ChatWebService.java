package com.cykj.marketadmin.service;

import com.cykj.marketadmin.webSocket.Msg;

public interface ChatWebService {
    int insertChatMsg(Msg msg);
}
