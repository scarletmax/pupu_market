package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Advertisement;
import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.LayData;
import com.cykj.marketpojo.Shop;
import com.cykj.marketshop.service.AdService;
import org.apache.http.HttpRequest;
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
import java.util.HashMap;
import java.util.UUID;

@Controller
@RequestMapping("adControl")
public class AdControl {
    @Autowired
    private AdService adService;
    @RequestMapping("showTable")
    @ResponseBody
//    @Log(operationType = "查看",operationName = "")
    //获取文件分页数据
    public String showTable(HttpServletRequest request)  {

        int curPage;
        if (request.getParameter("page") != null) {
            curPage = Integer.parseInt(request.getParameter("page"));
        } else {
            curPage = 1;
        }
        HashMap<String, Object> condition = new HashMap<>();
        HttpSession session= request.getSession();
        int shopId=(int)session.getAttribute("shopId");
        condition.put("shopId",shopId);
        //设置名字条件
        String title = request.getParameter("title");
        if (title != null && !title.trim().equals("")) {
            condition.put("title", title);
        }
        String goodName = request.getParameter("goodName");
        if (goodName != null && !goodName.trim().equals("")) {
            condition.put("goodName", goodName);
        }
        String typeStr = request.getParameter("typeStr");
        if (typeStr != null && !typeStr.trim().equals("")) {
            condition.put("typeStr", typeStr);
        }
        System.out.println(typeStr);
        String state=request.getParameter("state");
        if (state != null && !state.trim().equals("")) {
            condition.put("state", state);
        }
        Integer pageSize = Integer.parseInt(request.getParameter("limit"));
        condition.put("pageSize", pageSize);
        condition.put("startNum", (curPage - 1) * pageSize);
        LayData<Advertisement> advertisementLayData = adService.showTable(condition);
        return JSON.toJSONString(advertisementLayData);
    }
    @ResponseBody
    @RequestMapping("getAllType")
    public String getAllType(){
        return JSON.toJSONString(adService.getAllType());
    }

    @RequestMapping("updateState")
    @ResponseBody
    public String updateState(int id,int state,HttpServletRequest request) {
        HttpSession session= request.getSession();
        int shopId=(int)session.getAttribute("shopId");
        return adService.updateState(id,state,shopId);
    }
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request, HttpServletResponse response, MultipartFile file, String fileName) {
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
            String savePath = request.getSession().getServletContext().getRealPath("/upload/adPic");
            //要保存的问题件路径和名称
            String projectPath = savePath +File.separator + uuid + "." + prefix;
            System.out.println("projectPath==" + projectPath);
            File files = new File(projectPath);
            String path="upload"+File.separator+ dateStr + File.separator + uuid + "." + prefix;
            System.out.println(path);

            //打印查看上传路径
            if (!files.getParentFile().exists()) {//判断目录是否存在
                    System.out.println("files11111=" + files.getPath());
                    files.getParentFile().mkdirs();
            }
            file.transferTo(files); // 将接收的文件保存到指定文件中
//            Advertisement ad= new Advertisement();
//            ad.setPicUrl("/"+uuid+"."+prefix);
            request.getSession().setAttribute("adPicUrl","/"+uuid+"."+prefix);
            LayData layData = new LayData();
            layData.setCode(0);
            layData.setMsg("上传成功");
            return JSON.toJSONString(layData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @ResponseBody
    @RequestMapping("updateAd")
    public String updateAd(String adJson, HttpServletRequest request) {
        Advertisement ad= JSON.parseObject(adJson,Advertisement.class);
        if(ad.getTitle()!=null && !ad.getTitle().equals("")){
            String picUrl=(String) request.getSession().getAttribute("adPicUrl");
            if(picUrl!=null && !picUrl.equals("")){
                ad.setPicUrl(picUrl);
            }
            return adService.updateAd(ad)>0?"success":"fail";
        }
      return "fail";
    }
    @ResponseBody
    @RequestMapping("newAd")
    public String newAd(HttpServletRequest request,String adJson){
        Advertisement ad= JSON.parseObject(adJson,Advertisement.class);
        if(ad.getTitle()!=null && !ad.getTitle().equals("")){
            String picUrl=(String) request.getSession().getAttribute("adPicUrl");
            int shopId = (int)request.getSession().getAttribute("shopId");
            ad.setShopId(shopId);
            if(picUrl!=null && !picUrl.equals("")){
                ad.setPicUrl(picUrl);
                return adService.newAd(ad)>0?"success":"fail";
            }else {
                return "noPic";
            }
        }
        return  "fail";
    }
}
