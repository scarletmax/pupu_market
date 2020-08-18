package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.cykj.marketpojo.Admin;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.service.LoginService;
import com.cykj.marketshop.util.MD5Util;
import com.cykj.marketshop.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static com.cykj.marketshop.util.SmsUtils.sendSms;

@Controller
@RequestMapping("/loginControl")
public class LoginControl {
    @Autowired
    public LoginService loginService;

    @RequestMapping(value = "/login")
    @ResponseBody
//    @Log(operationType = "操作",operationName = "管理员登录")
    //管理员登录
    public String login(HttpServletRequest request)  {
        String adminJson = request.getParameter("adminJson");
        System.out.println(adminJson);
        ShopAdmin userAdmin = JSON.parseObject(adminJson, ShopAdmin.class);
        ShopAdmin admin= loginService.login(userAdmin);
        if (admin != null) {
            if(admin.getState()==1){
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                session.setAttribute("shopId",admin.getShopId());
                request.getSession().setAttribute("isLogin", true);
                return "success";
            }else {
                return "state";
            }

        } else {
            return "error";
        }
    }
    @RequestMapping(value = "/telverify")
    @ResponseBody
    public String telverify(String tel,HttpServletRequest request){
        String msg=null;

        if(tel!=null&&!tel.equals("")){
            SmsUtils.setNewcode();
            String code = Integer.toString(SmsUtils.getNewcode());
            SendSmsResponse sendSms = null;//填写你需要测试的手机号码
            try {
                sendSms = sendSms(tel,code);

            } catch (ClientException e) {
                e.printStackTrace();
            }
            System.out.println("短信接口返回的数据----------------");
            System.out.println("Code=" + sendSms.getCode());
            System.out.println("Message=" + sendSms.getMessage());
            System.out.println("RequestId=" + sendSms.getRequestId());
            System.out.println("BizId=" + sendSms.getBizId());
            if (sendSms.getMessage().equals("OK")){
                msg="success";
                HttpSession session = request.getSession();
                session.setAttribute("code", code);
            }else {
                msg="fail";
            }
        }


        return msg;
    }
    @RequestMapping(value = "/telLogin")
    @ResponseBody
    public String telLogin(String tel,String code,HttpServletRequest request){
        System.out.println("code="+code);
        System.out.println("tel="+tel);

        if(code!=null&&!code.equals("")){
            HttpSession session = request.getSession();
             String oldcode = (String) session.getAttribute("code");
            System.out.println("oldcode="+oldcode);
            if(code.equals(oldcode)){
                ShopAdmin admin= loginService.telLogin(tel);
                if (admin != null) {
                    if(admin.getState()==1){
                        session.setAttribute("admin", admin);
                        request.getSession().setAttribute("isLogin", true);
                        return "success";
                    }else {
                        return "state";
                    }


                } else {
                    return "error";
                }
            }else {
                return "vCodeError";
            }

        }else {
            return "vCodeError";
        }
    }
    @RequestMapping(value = "/changePwd")
    @ResponseBody
    public  String changePwd(String newPwd,String oldPwd,String tel,String code,HttpServletRequest request){

        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("pwd", MD5Util.md5(newPwd));
        hashMap.put("tel",tel);

        if(code!=null&&!code.equals("")){
            HttpSession session = request.getSession();
            String oldcode = (String) session.getAttribute("code");
            System.out.println("oldcode="+oldcode);
            if(code.equals(oldcode)){
                int a=loginService.changePwd(hashMap);

                if(a>0){
                    return "success";
                }

            }else {
                return "vCodeError";
            }
        }

        return "vCodeError";
    }
    @RequestMapping(value = "/extShop")
    @ResponseBody
    public String extShop(HttpServletRequest request){

        HttpSession session = request.getSession();

        session.setAttribute("admin", new Admin());
        return "success";
    }

}
