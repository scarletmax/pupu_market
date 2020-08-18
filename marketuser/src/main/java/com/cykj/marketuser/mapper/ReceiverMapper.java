package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Receiver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiverMapper {
    List<Receiver> getAllAddr(int userId);
    Integer editAddr(Receiver receiver);
    Integer addAddr(Receiver receiver);
    Integer cancelAll(Receiver receiver);
}
