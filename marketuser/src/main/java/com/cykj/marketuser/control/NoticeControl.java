package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Goods;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Notice;
import com.cykj.marketpojo.ShopAdmin;
import com.cykj.marketuser.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/noticeControl")
public class NoticeControl {
    @Autowired
    public NoticeService noticeService;


    @RequestMapping(value = "/getNoticeList")
    @ResponseBody
    public String getNoticeList(HttpServletRequest request) {
        List<Notice> noticeList = noticeService.getNoticeList();
        return JSON.toJSONString(noticeList);
    }



}



