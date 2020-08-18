package com.cykj.marketdelivery.control;


import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.cykj.marketdelivery.service.LoginService;
import com.cykj.marketdelivery.service.RegisterService;
import com.cykj.marketdelivery.service.UserService;
import com.cykj.marketdelivery.util.MD5Util;
import com.cykj.marketdelivery.util.SmsUtils;
import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

@Controller
@RequestMapping("registerControl")
public class RegisterControl {

    @Resource
    private RegisterService registerService;

    @RequestMapping(value = "/telVerify")
    @ResponseBody
    public String telVerify(String tel,HttpServletRequest request,HttpServletResponse response){
        if(registerService.isTelRepeat(tel)!=0){
            return "telRepeat";
        }
        SmsUtils.setNewcode();
        String code = Integer.toString(SmsUtils.getNewcode());
        try {
            SendSmsResponse SSR = SmsUtils.sendSms(tel,code);
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



    @RequestMapping(value = "/uploadImage")
    @ResponseBody
    public String uploadImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile thisFile) throws ServletException, IOException {
        try {

            String lastUrl = request.getParameter("lastUrl");
            System.out.println("上一次"+lastUrl);
            if(!lastUrl.equals("")){
                String deletePath = request.getSession().getServletContext().getRealPath("/upload/delivery_pic")+lastUrl;
                new File(deletePath).delete();
            }
            //获取文件名
            String originalName = thisFile.getOriginalFilename();
            //获取扩展名
            String suffix = originalName.substring(originalName.lastIndexOf(".") + 1);
            //使用UUID+后缀名保存文件名，防止中文乱码问题
            String uuid = UUID.randomUUID() + "";
            String savePath = request.getSession().getServletContext().getRealPath("/upload/delivery_pic");
            //最终实际保存路径
            String filePath = savePath + File.separator + uuid + "." + suffix;
            File files = new File(filePath);
            //打印查看上传路径
            if (!files.getParentFile().exists()) {//判断目录是否存在，否则创建父目录
                files.getParentFile().mkdirs();
            }
            thisFile.transferTo(files); // 将接收的文件保存到指定文件中
            System.out.println("这次"+File.separator + uuid + "." + suffix);
            return File.separator + uuid + "." + suffix;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //注册失败捕捉异常，删除图片
    //badRequest
    @RequestMapping(value = "/register")
    @ResponseBody
    public void register(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        String tel = request.getParameter("tel");
        String idCard = request.getParameter("idCard");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String picCardFront = request.getParameter("picCardFront");
        String picCardBack = request.getParameter("picCardBack");
        String picPerson = request.getParameter("picPerson");

        Deliveryman deliveryman = new Deliveryman(0,account,name,tel,idCard,sex,age,0,null,0,0.0,0.0,0.0,MD5Util.md5(pwd),picCardFront,picCardBack,picPerson);
        try {
            registerService.register(deliveryman);
        } catch (Exception e) {
            response.setStatus(201);
            String deletePath1 = request.getSession().getServletContext().getRealPath("/upload/delivery_pic")+deliveryman.getPicCardFront();
            new File(deletePath1).delete();
            String deletePath2 = request.getSession().getServletContext().getRealPath("/upload/delivery_pic")+deliveryman.getPicCardBack();
            new File(deletePath1).delete();
            String deletePath3 = request.getSession().getServletContext().getRealPath("/upload/delivery_pic")+deliveryman.getPicPerson();
            new File(deletePath1).delete();
            e.printStackTrace();
        }
    }




}
