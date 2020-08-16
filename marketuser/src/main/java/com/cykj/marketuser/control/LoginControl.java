package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cykj.marketpojo.User;
import com.cykj.marketuser.service.LoginService;
import com.cykj.marketuser.util.MD5Util;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginControl {
    //小程序appid ，需要改为真实的
    private final static String APPID = "wxafe69f0923288290";
    //小程序secret ，需要改为真实的
    private final static String SECRET = "60c260dceb06f2ee5ba657ee50638e61";
    @Autowired
    private LoginService loginService;
    /**
     * 通过 appid & secret & code 获取 openid
     *
     * @param code
     */
    @GetMapping("/getOpenid/{code}")
    @ResponseBody
    public String getOpenid(@PathVariable String code) throws IOException {
        //wx接口路径
        String url = "https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code&" +
                "appid=" + APPID + "&secret=" + SECRET + "&js_code=" + code;
        //使用HttpClient发送请求
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //发送Get请求
        HttpGet request = new HttpGet(url);
        request.addHeader("Content-Type", "application/json");
        //获得响应
        CloseableHttpResponse response = httpclient.execute(request);
        //拿到响应体
        HttpEntity httpEntity = response.getEntity();
        //使用工具转换
        String result = EntityUtils.toString(httpEntity, "UTF-8");// 转成string
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject);//拿到的所有内容
        String openid = jsonObject.get("openid").toString();
        System.out.println(openid);//拿到的openid
        return openid;
    }

    @ResponseBody
    @RequestMapping("weixinLogin")
    public String weixinLogin(@Param("code") String code, @RequestParam("headurl") String iconUrl,
                              @RequestParam("nickname") String name,@Param("openid") String openid) {
        User user =new User(name,iconUrl,openid);
        user= loginService.weixinLogin(user);

        return JSON.toJSONString(user);

    }
    @ResponseBody
    @RequestMapping("telLogin")
    public String telLogin(String tel,String pwd){
        return JSON.toJSONString(loginService.loginByTel(tel, MD5Util.md5(pwd)));
    }

}
