package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.PropertyService;
import com.cykj.marketadmin.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/propertyControl")
public class PropertyControl {

    @Autowired
    private PropertyService propertyService;
    @Log(operationType = "查看",operationName = "")
    @RequestMapping(value = "/findProperty")
    public String findProperty(String type,String typeText,String name,int limit,int page){

        System.out.println("type="+type+" typeText="+typeText+" name="+name);
        if (limit== 0) {
            limit=10;
        }
        if (page != 0) {

            page = (page - 1) * limit;
        } else {
            page = 0;
        }
        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("type",type);
        hashMap.put("typeText",typeText);
        hashMap.put("name",name);

        hashMap.put("limit",limit);
        hashMap.put("page",page);

        return JSON.toJSONString(propertyService.findProperty(hashMap));
    }
    @RequestMapping(value = "/haveName")
    @Log(operationType = "查看",operationName = "")
    public String haveName(String name ,String value,String type){

        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("type",type);
        hashMap.put("value",value);
        hashMap.put("name",name);
        int a=propertyService.findCount(hashMap);
        String msg=null;
        if (a>0){
            msg="success";
        }else {
            msg="fail";
        }


        return msg;
    }
    @RequestMapping(value = "/haveValue")
    @Log(operationType = "查看",operationName = "")
    public String haveValue(String name ,String value,String type){

        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("type",type);
        hashMap.put("value",value);
        hashMap.put("name",name);
        int a=propertyService.findCount(hashMap);
        String msg=null;
        if (a>0){
            msg="success";
        }else {
            msg="fail";
        }


        return msg;
    }
    @RequestMapping(value = "/changeProperty")
    @Log(operationType = "操作",operationName = "更改配置")
     public String changeProperty(String name ,String value,String type,int id){
        String msg=null;
        System.out.println("type="+type+" value="+value+" name="+name);
        String str=haveValue(name,value,type);
        String str2=haveName(name,value,type);
        if(type!=null&&type.equals("reset_pwd")){
           value= MD5Util.md5(value);

        }
        if(str.equals("fail")&&str2.equals("fail")){
            HashMap<String ,Object> hashMap=new HashMap<>();
            hashMap.put("type",type);
            hashMap.put("value",value);
            hashMap.put("name",name);
            hashMap.put("id",id);
            int a= propertyService.changeProperty(hashMap);

            if (a>0){
                msg="success";
            }else {
                msg="fail";
            }
        }
        return msg;
     }

}
