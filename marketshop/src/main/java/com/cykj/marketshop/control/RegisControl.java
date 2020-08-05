package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Shop;

import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketshop.service.LoginService;
import com.cykj.marketshop.service.RegisService;
import com.cykj.marketshop.util.MD5Util;
import com.cykj.marketshop.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static com.cykj.marketshop.util.SmsUtils.sendSms;

@Controller
@RequestMapping("/regisControl")
public class RegisControl {
    @Autowired
    public RegisService regisService;

    @RequestMapping(value = "/verifyName")
    @ResponseBody
    public String verifyName(String name){

        int a=regisService.verifyName(name);
        if(a>0){
            return "fail";
        }

        return "success";
    }
    @RequestMapping(value = "/verifyTel")
    @ResponseBody
    public String verifyTel(String tel){

        int a=regisService.verifyTel(tel);
        if(a>0){
            return "fail";
        }

        return "success";
    }
    @RequestMapping(value = "/insertShop")
    @ResponseBody
    public String insertShop(HttpServletRequest request,String name,String address,String bossName,String verifyID,String pwd,String tel,String info,Shop shop){

        System.out.println("name="+name+" address="+address+" bossName="+bossName+" verifyID="+verifyID+" pwd="+pwd+" tel="+tel+" info="+info);
        System.out.println("shop="+shop.toString());
        HttpSession httpSession=request.getSession();
        shop.setPwd(MD5Util.md5(shop.getPwd()));
        httpSession.setAttribute("shop",shop);

//        int a=regisService.insertShop(shop);
//        if(a>0){
//            return "fail";
//        }

        return "success";
    }
    @RequestMapping(value = "/uploadVerifyPic")
    @ResponseBody
    public String uploadVerifyPic(HttpServletRequest request, HttpServletResponse response, MultipartFile file, String fileName) {
        System.out.println("fileName=" + fileName);
        try {
            //获取文件名
            String originalName = file.getOriginalFilename();
            System.out.println("originalName=" + originalName);
            //扩展名
            String prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
            Date date = new Date();
            //使用UUID+后缀名保存文件名，防止中文乱码问题
            String uuid = UUID.randomUUID() + "";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = simpleDateFormat.format(date);
            String  str="/uploadVerifyPic/";

            String savePath = request.getSession().getServletContext().getRealPath("/uploadVerifyPic/");
            //要保存的问题件路径和名称
            String projectPath = savePath + dateStr + File.separator + uuid + "." + prefix;
            //数据库保存名称
            String datePath=str+dateStr + File.separator + uuid + "." + prefix;

            System.out.println("projectPath==" + projectPath);
            File files = new File(projectPath);
            //打印查看上传路径
            if (!files.getParentFile().exists()) {//判断目录是否存在
                System.out.println("files11111=" + files.getPath());
                files.getParentFile().mkdirs();
            }
            file.transferTo(files); // 将接收的文件保存到指定文件中
            System.out.println(projectPath);
            LayData layuiData = new LayData();
            layuiData.setCode(0);
            layuiData.setMsg("上传成功");

            HttpSession httpSession=request.getSession();
           Shop shop=(Shop) httpSession.getAttribute("shop");
           shop.setVerifyPic(datePath);

            return JSON.toJSONString(layuiData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/uploadShopPic")
    @ResponseBody
    public String uploadShopPic(HttpServletRequest request, HttpServletResponse response, MultipartFile file, String fileName) {
        System.out.println("fileName=" + fileName);
        try {
            //获取文件名
            String originalName = file.getOriginalFilename();
            //扩展名
            String prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
            Date date = new Date();
            //使用UUID+后缀名保存文件名，防止中文乱码问题
            String uuid = UUID.randomUUID() + "";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = simpleDateFormat.format(date);
            String  str="/uploadShopPic/";
            String savePath = request.getSession().getServletContext().getRealPath(str);
            //要保存的问题件路径和名称
            String projectPath = savePath + dateStr + File.separator + uuid + "." + prefix;

            //数据库保存名称
            String datePath=str+dateStr + File.separator + uuid + "." + prefix;

            System.out.println("projectPath==" + projectPath);
            System.out.println("datePath==" + datePath);
            File files = new File(projectPath);
            //打印查看上传路径
            if (!files.getParentFile().exists()) {//判断目录是否存在
                System.out.println("files11111=" + files.getPath());
                files.getParentFile().mkdirs();
            }
            file.transferTo(files); // 将接收的文件保存到指定文件中
            System.out.println(projectPath);
            LayData layuiData = new LayData();

            layuiData.setCode(0);
            layuiData.setMsg("上传成功");

            HttpSession httpSession=request.getSession();
            Shop shop=(Shop) httpSession.getAttribute("shop");
            shop.setShopPic(datePath);

            return JSON.toJSONString(layuiData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping(value = "/insertInfo")
    @ResponseBody
    public String insertInfo(HttpServletRequest request){

        HttpSession httpSession=request.getSession();
        Shop shop=(Shop) httpSession.getAttribute("shop");
        if(shop.getShopPic()!=null&&!shop.getShopPic().equals("")&&shop.getVerifyPic()!=null&&!shop.getVerifyPic().equals("")){

            String oldcode = (String) httpSession.getAttribute("code");
            System.out.println("oldcode="+oldcode);

            if(shop.getCode().equals(oldcode)){
                System.out.println("shop====="+shop.toString());
             String str=   regisService.insertShop(shop);
             if(str.equals("success")){
                 return "success";
             }else {
                 return "fail";
             }

            }

        }

        return "fail";
    }





}
