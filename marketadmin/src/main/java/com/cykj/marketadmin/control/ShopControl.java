package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;

import com.cykj.marketadmin.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public  Object changeState(int id,String purpose){

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
    public Object findShop(String bossName,String shopName,String startTime,String endTime,int limit,int page){

        System.out.println("bossName="+bossName+" shopName="+shopName+" startTime="+startTime+" endTime="+endTime);
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

        hashMap.put("startTime",startTime);
        hashMap.put("endTime",endTime);
        hashMap.put("limit",limit);
        hashMap.put("page",page);

        return JSON.toJSONString(shopService.findShop(hashMap));
    }

    @RequestMapping("/searchShop")
    @ResponseBody
    public String searchShop(HttpServletRequest request, HttpServletResponse response){
        return JSON.toJSONString(shopService.searchShop());
    }
}
