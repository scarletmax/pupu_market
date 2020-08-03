package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/shopControl")
public class ShopControl {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/findShopAdmin")
    @ResponseBody
    public Object findShopAdmin(String userName,String account,String shopName,String startTime,String endTime,int limit,int page){

        System.out.println("userName="+userName+" account="+account+" shopName="+shopName+" startTime="+startTime+" endTime="+endTime);
        if (limit== 0) {
            limit=10;
        }
        if (page != 0) {

            page = (page - 1) * limit;
        } else {
            page = 0;
        }
        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("userName",userName);
        hashMap.put("shopName",shopName);
        hashMap.put("account",account);
        hashMap.put("startTime",startTime);
        hashMap.put("endTime",endTime);
        hashMap.put("limit",limit);
        hashMap.put("page",page);

        return JSON.toJSONString(shopService.findShopAdmin(hashMap));
    }
    @RequestMapping(value = "/changeState")
    @ResponseBody
    public  Object changeShopAdminState(int id,String purpose){

        String msg=null;
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(purpose!=null&&!purpose.equals("")){
            hashMap.put("id",id);
            if(purpose.equals("enable")){

                hashMap.put("state",1);
            }else if(purpose.equals("disable")){
                hashMap.put("state",2);
            }else if(purpose.equals("del")){
                hashMap.put("state",3);
            }
        }
       int a =shopService.changeState(hashMap);
        if (a>0){
            msg="success";
        }else{
            msg="fail";
        }
        return msg;
    }
    @RequestMapping(value = "/findShop")
    @ResponseBody
    public Object findShop(String bossName,String shopName,String startTime,String endTime,int limit,int page ,String state){

        System.out.println("bossName="+bossName+" shopName="+shopName+" startTime="+startTime+" endTime="+endTime+" state="+state);
        if (limit== 0) {
            limit=10;
        }
        if (page != 0) {

            page = (page - 1) * limit;
        } else {
            page = 0;
        }
        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("bossName",bossName);
        hashMap.put("shopName",shopName);
        if(state!=null&&!state.equals("0")){
            hashMap.put("state",state);
        }

        hashMap.put("startTime",startTime);
        hashMap.put("endTime",endTime);
        hashMap.put("limit",limit);
        hashMap.put("page",page);

        return JSON.toJSONString(shopService.findShop(hashMap));
    }
    @RequestMapping(value = "/verifyAccount")
    @ResponseBody
    public Object verifyAccount(String account){

        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("account",account);
       int a=  shopService.verifyAccount(hashMap);

       String str=null;
       if(a>0){
           str="fail";
       }else {
           str="success";
       }
        return str;
    }

    @RequestMapping(value = "/insertShopAdmin")
    @ResponseBody
    public String insertShopAdmin(String account,String userName,String tel,int shopId,String pwd){
        String msg=null;
        if(verifyAccount(account).equals("success")){
            HashMap<String ,Object> hashMap=new HashMap<>();
            hashMap.put("account",account);
            hashMap.put("pwd",pwd);
            hashMap.put("name",userName);
            hashMap.put("tel",tel);
            hashMap.put("shopId",shopId);

            int a =shopService.insertShopAdmin(hashMap);
            if (a>0){
                msg="success";
            }else{
                msg="fail";
            }
        }else {
            msg="fail";
        }

        return msg;
    }
    @RequestMapping(value = "/shopList")
    @ResponseBody
    public Object shopList(){

        return JSON.toJSONString(shopService.shopList());
    }
    @RequestMapping(value = "/changeShopState")
    @ResponseBody
    public  Object changeShopState(int id,String purpose){

        String msg=null;
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(purpose!=null&&!purpose.equals("")){
            hashMap.put("id",id);
            if(purpose.equals("passing")){

                hashMap.put("state",1);
            }else if(purpose.equals("pass")){
                hashMap.put("state",2);
            }else if(purpose.equals("noPass")){
                hashMap.put("state",3);
            }
        }
        int a =shopService.changeShoopState(hashMap);
        if (a>0){
            msg="success";
        }else{
            msg="fail";
        }
        return msg;
    }
    //添加注释
    @RequestMapping(value = "/findProperty")
    @ResponseBody
    public Object findProperty(){
        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("porperty","shop_state");

        return JSON.toJSONString(shopService.findProperty(hashMap));
    }
}
