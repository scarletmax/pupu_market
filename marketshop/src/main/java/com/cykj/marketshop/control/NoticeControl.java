package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.*;
import com.cykj.marketshop.service.NoticeService;
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

    @RequestMapping(value = "/findNoticeState")
    @ResponseBody
    public String findNoticeState(HttpServletRequest request) {
        List<String> noticeList = noticeService.findNoticeState();
        return JSON.toJSONString(noticeList);
    }

    @RequestMapping(value = "/findNoticeList")
    @ResponseBody
    public String findNoticeList(HttpServletRequest request) {
        ShopAdmin admin = (ShopAdmin) request.getSession().getAttribute("admin");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("id", admin.getShopId());
        String name = request.getParameter("name");
        if (name != null && !name.trim().equals("")) {
            condition.put("name", name);
        }
        String startDate = request.getParameter("startDate");
        if (startDate != null && !startDate.trim().equals("")) {
            condition.put("startDate", startDate);
        }
        String endDate = request.getParameter("endDate");
        if (endDate != null && !endDate.trim().equals("")) {
            condition.put("endDate", endDate);
        }

        String stateStr = request.getParameter("stateStr");
        if (stateStr != null && !stateStr.trim().equals("")) {
            condition.put("stateStr", stateStr);
        }
        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        int start = (pageNum - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        condition.put("start", start);
        condition.put("pageSize", pageSize);
        LayData layuiData = new LayData();
        layuiData = noticeService.findNoticeList(condition);
        return JSON.toJSONString(layuiData);
    }

    @RequestMapping("/updateNoticeState")
    @ResponseBody
    public String updateNoticeState(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String state = request.getParameter("state");
        if (noticeService.updateNoticeState(id, state)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/addNotice")
    @ResponseBody
    public String addNotice(HttpServletRequest request, HttpServletResponse response) {
        String noticeInfo = request.getParameter("noticeInfo");
        System.out.println("noticeInfo="+noticeInfo);
        Notice notice = JSON.parseObject(noticeInfo, Notice.class);
        ShopAdmin admin = (ShopAdmin) request.getSession().getAttribute("admin");
        notice.setShopId(admin.getShopId());
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("notice", notice);
        return "success";
    }

    @RequestMapping(value = "/addNoticePic")
    @ResponseBody
    public String addNoticePic(HttpServletRequest request, HttpServletResponse response, MultipartFile file, String fileName) {
        System.out.println("fileName=" + fileName);
        try {
            //获取文件名
            String originalName = file.getOriginalFilename();
            //扩展名
            String prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
            Date date = new Date();
            //使用UUID+后缀名保存文件名，防止中文乱码问题
            String uuid = UUID.randomUUID() + "";
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String dateStr = simpleDateFormat.format(date);
            String  str="/uploadNoticePic/";
            String savePath = request.getSession().getServletContext().getRealPath("/uploadNoticePic/");
            //要保存的问题件路径和名称
            String projectPath = savePath + File.separator + uuid + "." + prefix;

            //数据库保存名称
            String datePath=File.separator + uuid + "." + prefix;

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

            HttpSession httpSession = request.getSession();
            Notice notice = (Notice) httpSession.getAttribute("notice");
            notice.setPicUrl(datePath);

            return JSON.toJSONString(layuiData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/insertNoticeInfo")
    @ResponseBody
    public String insertNoticeInfo(HttpServletRequest request) {

        HttpSession httpSession = request.getSession();
        Notice notice = (Notice) httpSession.getAttribute("notice");
        if (notice.getPicUrl() != null && !notice.getPicUrl().equals("")) {
            int a = 0;
            a = noticeService.addNotice(notice);
            if (a == 1) {
                return "success";
            } else {
                return "fail";
            }

        }
        return "fail";
    }

    @RequestMapping("/updateNoticeInfo")
    @ResponseBody
    public String editNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        Notice notice = (Notice) httpSession.getAttribute("notice");
        System.out.println(notice.getId()+"=id");
        if (notice.getPicUrl() != null && !notice.getPicUrl().equals("")) {
            int a = 0;
            a = noticeService.updateNotice(notice);
            if (a == 1) {
                return "success";
            } else {
                return "fail";
            }

        }
        return "fail";
    }

}



