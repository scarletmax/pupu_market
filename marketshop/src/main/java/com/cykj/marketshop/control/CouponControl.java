package com.cykj.marketshop.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Coupon;
import com.cykj.marketpojo.*;
import com.cykj.marketshop.service.CouponService;
import com.cykj.marketshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/couponControl")
public class CouponControl {
    @Autowired
    public CouponService couponService;
//    获取优惠券状态
    @RequestMapping(value = "/findCouponState")
    @ResponseBody
    public String findCouponState(HttpServletRequest request) {
        List<String> couponList = couponService.findCouponState();
        return JSON.toJSONString(couponList);
    }
//    获取优惠券列表
    @RequestMapping(value = "/findCouponList")
    @ResponseBody
    public String findCouponList(HttpServletRequest request) {
        ShopAdmin admin = (ShopAdmin) request.getSession().getAttribute("admin");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("id", admin.getShopId());
        String name = request.getParameter("name");
        if (name != null && !name.trim().equals("")) {
            condition.put("name", name);
        }
        String favor = request.getParameter("favor");
        if (favor != null && !favor.trim().equals("")) {
            condition.put("favor", favor);
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
        layuiData = couponService.findCouponList(condition);
        return JSON.toJSONString(layuiData);
    }

    @RequestMapping("/updateState")
    @ResponseBody
    public String updateState(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String state = request.getParameter("state");
        if (couponService.updateState(id, state)) {
            return "success";
        } else {
            return "fail";
        }
    }
//    新增优惠券
    @RequestMapping(value = "/addCouppon")
    @ResponseBody
    public String addCouppon(HttpServletRequest request, HttpServletResponse response) {
        String couponInfo = request.getParameter("couponInfo");
        Coupon coupon = JSON.parseObject(couponInfo, Coupon.class);
        ShopAdmin admin = (ShopAdmin) request.getSession().getAttribute("admin");
        coupon.setShopId(admin.getShopId());
        int a = 0;
        if (coupon != null) {

            a = couponService.addCouppon(coupon);
            if (a == 1) {
                return "success";
            } else {
                return "fail";
            }

        } else {
            return "fail";
        }
    }
    @RequestMapping(value = "findCouponUser")
    @ResponseBody
    public Object findCouponUser(int id){
        HashMap<String ,Object> hashMap=new HashMap<>();
        hashMap.put("id",id);
        System.out.println("findCouponUser");
        return JSON.toJSONString(couponService.findCouponUser(hashMap));
    }
}
