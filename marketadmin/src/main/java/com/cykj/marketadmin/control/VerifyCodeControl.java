package com.cykj.marketadmin.control;


import com.cykj.marketadmin.aop.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/verifyCodeControl")
public class VerifyCodeControl {
    @RequestMapping("/getVerify")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    protected void getVerify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //声明验证码
        int width = 60;
        int height = 30;
        String data = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789abcdefghijklmnpqrstuvwxyz";    //随机字符字典，其中0，o，1，I 等难辨别的字符最好不要
        Random random = new Random();//随机类
        //1 创建图片数据缓存区域（核心类）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//创建一个彩色的图片
        //2 获得画板(图片，ps图层)，绘画对象。
        Graphics g = image.getGraphics();
        //3 选择颜色，画矩形3，4步是画一个有内外边框的效果
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        //4白色矩形
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, width-2, height-2);

        /**1 提供缓存区域，为了存放4个随机字符，以便存入session */
        StringBuilder builder = new StringBuilder();

        //5 随机生成4个字符
        //设置字体颜色
        g.setFont(new Font("宋体", Font.BOLD&Font.ITALIC, 20));
        for(int i = 0 ; i < 4 ;i ++){
            //随机颜色
            g.setColor(new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255)));

            //随机字符
            int index = random.nextInt(data.length());
            String str = data.substring(index, index + 1);

            /**2 缓存*/
            builder.append(str);

            //写入
            g.drawString(str, (width / 6) * (i + 1) , 20);
        }
        //给图中绘制噪音点，让图片不那么好辨别
        for(int j=0,n=random.nextInt(100);j<n;j++){
            g.setColor(Color.RED);
            g.fillRect(random.nextInt(width),random.nextInt(height),1,1);//随机噪音点
        }

        /**3 获得随机数据，并保存session*/
        String tempStr = builder.toString();
        request.getSession().setAttribute("vcode",tempStr);

        //.. 生成图片发送到浏览器 --相当于下载
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
