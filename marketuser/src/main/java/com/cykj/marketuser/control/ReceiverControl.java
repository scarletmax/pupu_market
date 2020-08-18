package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Receiver;
import com.cykj.marketuser.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("receiver")
public class ReceiverControl {
    @Autowired
    private ReceiverService receiverService;
    @ResponseBody
    @RequestMapping("getAllAddr")
    public String getAllAddr(int userId){
        return JSON.toJSONString(receiverService.getAllAddr(userId));
    }
    @ResponseBody
    @RequestMapping("editAddr")
    public String editAddr(String receiverStr){
        Receiver receiver= JSON.parseObject(receiverStr,Receiver.class);
        return receiverService.editAddr(receiver);
    }
    @ResponseBody
    @RequestMapping("addAddr")
    public String addAddr(String receiverStr){
        Receiver receiver= JSON.parseObject(receiverStr,Receiver.class);
        return receiverService.addAddr(receiver);
    }
}
