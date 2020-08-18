package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("chatControl")
public class ChatControl {

    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/findChatMsg")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public Object findChatMsg(String acc){

        HashMap<String ,Object> hashMap=new HashMap<>();
        if(acc!=null&& !acc.equals("")){
            hashMap.put("acc",acc);
            return JSON.toJSONString(chatService.findChatMsg(hashMap));
        }

//        chatService.findChatMsg(hashMap);
        return null;
    }
    @RequestMapping(value = "/insertSaveAcc")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public Object insertSaveAcc(String chatAcc,String charUser){

     String   msg=null;
        HashMap<String ,Object> hashMap =new HashMap<>();
        hashMap.put("chatAcc",chatAcc);
        hashMap.put("chatUser",charUser);
        int a=0;
        if(chatAcc!=null&&!chatAcc.equals("")&&charUser!=null&&!charUser.equals("")){

             a=  chatService.insertSaveAcc(hashMap);
        }

       if(a>0){
          msg="success" ;
       }else {
           msg="fail";
       }

        return msg;
    }
    @RequestMapping(value = "/findSaveAcc")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public Object findSaveAcc(){
        HashMap<String ,Object> hashMap =new HashMap<>();
        return JSON.toJSONString(chatService.findSaveAcc(hashMap));
    }
}
