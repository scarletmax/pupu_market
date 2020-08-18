package com.cykj.marketuser.service;

import com.cykj.marketpojo.Receiver;

import java.util.List;

public interface ReceiverService {
    List<Receiver> getAllAddr(int userId);
    String editAddr(Receiver receiver);
    String addAddr(Receiver receiver);

}
