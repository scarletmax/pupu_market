package com.cykj.marketdelivery.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketdelivery.service.FundService;
import com.cykj.marketdelivery.service.UserService;
import com.cykj.marketdelivery.util.MD5Util;
import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.DeliverymanFund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("fundControl")
public class FundControl {
    @Autowired
    private FundService fundService;

    @RequestMapping(value = "/getCapital")
    @ResponseBody
    public String getCapital(String id,String type, HttpServletRequest request){
        int capitalMoney = fundService.getCapital(Integer.valueOf(id).intValue(),Integer.valueOf(type).intValue());
        return capitalMoney+"";
    }

    @RequestMapping(value = "/getMonthCapital")
    @ResponseBody
    public String getMonthCapital(String id, HttpServletRequest request){
        List<DeliverymanFund> monthCapital = fundService.getMonthCapital(Integer.valueOf(id).intValue());
        return JSON.toJSONString(monthCapital);
    }

    @RequestMapping(value = "/getWithdrawal")
    @ResponseBody
    public String getWithdrawal(String id, HttpServletRequest request){
        List<DeliverymanFund> withdrawal = fundService.getWithdrawal(Integer.valueOf(id).intValue());
        return JSON.toJSONString(withdrawal);
    }

    @RequestMapping(value = "/getDayCapital")
    @ResponseBody
    public String getDayCapital(String id, HttpServletRequest request){
        List<DeliverymanFund> dayCapital = fundService.getDayCapital(Integer.valueOf(id).intValue());
        return JSON.toJSONString(dayCapital);
    }

    @RequestMapping(value = "/getLastDayCapital")
    @ResponseBody
    public String getLastDayCapital(String id, HttpServletRequest request){
        List<DeliverymanFund> lastDayCapital = fundService.getLastDayCapital(Integer.valueOf(id).intValue());
        return JSON.toJSONString(lastDayCapital);
    }

    @RequestMapping(value = "/addWithdraw")
    @ResponseBody
    public String addWithdraw(String id,String money, HttpServletRequest request){
        int result = fundService.addWithdraw(Integer.valueOf(id).intValue(),Double.valueOf(money));
        return result+"";
    }


}
