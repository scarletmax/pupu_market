package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.TypeService;
import com.cykj.marketpojo.LayData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import reactor.util.annotation.NonNull;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/uploadControl")
public class UploadControl {


    @RequestMapping(value = "/typeIconUpload")
    @ResponseBody
    public String upload(HttpServletRequest request, HttpServletResponse response,@RequestParam("file") MultipartFile thisFile) throws ServletException, IOException {
        try {
            //获取文件名
            String originalName = thisFile.getOriginalFilename();
            //获取扩展名
            String suffix = originalName.substring(originalName.lastIndexOf(".") + 1);
            //使用UUID+后缀名保存文件名，防止中文乱码问题
            String uuid = UUID.randomUUID() + "";
            String savePath = request.getSession().getServletContext().getRealPath("/upload/typeIcon");
            //最终实际保存路径
            String filePath = savePath + File.separator + uuid + "." + suffix;
            File files = new File(filePath);
            //打印查看上传路径
            if (!files.getParentFile().exists()) {//判断目录是否存在，否则创建父目录
                files.getParentFile().mkdirs();
            }
            thisFile.transferTo(files); // 将接收的文件保存到指定文件中

            LayData<String> layData=new LayData<String>();
            layData.setCode(0);
            layData.setData(Collections.singletonList(File.separator + uuid + "." + suffix));
            System.out.println("url"+layData.getData().toString());
            return JSON.toJSONString(layData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
