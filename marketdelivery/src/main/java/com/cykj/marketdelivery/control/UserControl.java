package com.cykj.marketdelivery.control;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.cykj.marketdelivery.service.RegisterService;
import com.cykj.marketdelivery.service.UserService;
import com.cykj.marketdelivery.util.MD5Util;
import com.cykj.marketdelivery.util.SmsUtils;
import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cykj.marketpojo.Deliveryman;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("userControl")
public class UserControl {
    @Autowired
    private UserService userService;

    @Resource
    private RegisterService registerService;

//  通过派送员传入的手机号密码实现派送员登陆
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String code,String mobile, HttpServletRequest request){
        String pwd= MD5Util.md5(code);
        Deliveryman deliveryman=new Deliveryman();
        deliveryman.setPwd(pwd);
        deliveryman.setTel(mobile);
        deliveryman = userService.login(deliveryman);
        if (deliveryman==null){
            deliveryman.setState(0);
        }
        return JSON.toJSONString(deliveryman);
    }
//  通过扫脸回传的ID实现用户登陆
    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public String getUserInfo(String id, HttpServletRequest request){
        Deliveryman deliveryman = userService.getUserInfo(Integer.valueOf(id).intValue());
        return JSON.toJSONString(deliveryman);
    }


    @RequestMapping(value = "/telVerify")
    @ResponseBody
    public String telVerify(String mobile, HttpServletRequest request, HttpServletResponse response){
        if(registerService.isTelRepeat(mobile)==0){
            return "telRepeat";
        }
        SmsUtils.setNewcode();
        String code = Integer.toString(SmsUtils.getNewcode());
        try {
            SendSmsResponse SSR = SmsUtils.sendSms(mobile,code);
            System.out.println("短信接口返回的数据----------------");
            System.out.println("Code=" + SSR.getCode());
            System.out.println("Message=" + SSR.getMessage());
            System.out.println("RequestId=" + SSR.getRequestId());
            System.out.println("BizId=" + SSR.getBizId());
            return code;
        } catch (ClientException e) {
            e.printStackTrace();
            return "fail";
        }

    }

    @RequestMapping(value = "/forgetPwd")
    @ResponseBody
    public void forgetPwd(HttpServletRequest request, HttpServletResponse response){
        String pwd = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        Deliveryman deliveryman = new Deliveryman();
        pwd=MD5Util.md5(pwd);
        deliveryman.setPwd(pwd);
        deliveryman.setTel(phone);
        try {
        userService.forgetPwd(deliveryman);
//        return JSON.toJSONString(deliveryman);
        } catch (Exception e) {
            response.setStatus(201);
            e.printStackTrace();
        }
    }

}
