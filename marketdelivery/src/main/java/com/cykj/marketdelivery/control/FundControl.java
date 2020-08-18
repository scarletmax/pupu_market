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

//   根据类型获取派送员的收入或者提现金额
    @RequestMapping(value = "/getCapital")
    @ResponseBody
    public String getCapital(String id,String type, HttpServletRequest request){
        int capitalMoney = fundService.getCapital(Integer.valueOf(id).intValue(),Integer.valueOf(type).intValue());
        return capitalMoney+"";
    }
//  获取派送员本月的收入列表
    @RequestMapping(value = "/getMonthCapital")
    @ResponseBody
    public String getMonthCapital(String id, HttpServletRequest request){
        List<DeliverymanFund> monthCapital = fundService.getMonthCapital(Integer.valueOf(id).intValue());
        return JSON.toJSONString(monthCapital);
    }
//    获取用户的提现列表
    @RequestMapping(value = "/getWithdrawal")
    @ResponseBody
    public String getWithdrawal(String id, HttpServletRequest request){
        List<DeliverymanFund> withdrawal = fundService.getWithdrawal(Integer.valueOf(id).intValue());
        return JSON.toJSONString(withdrawal);
    }
//    获取用户今日的收入列表
    @RequestMapping(value = "/getDayCapital")
    @ResponseBody
    public String getDayCapital(String id, HttpServletRequest request){
        List<DeliverymanFund> dayCapital = fundService.getDayCapital(Integer.valueOf(id).intValue());
        return JSON.toJSONString(dayCapital);
    }
 //    获取用户昨日的收入列表
    @RequestMapping(value = "/getLastDayCapital")
    @ResponseBody
    public String getLastDayCapital(String id, HttpServletRequest request){
        List<DeliverymanFund> lastDayCapital = fundService.getLastDayCapital(Integer.valueOf(id).intValue());
        return JSON.toJSONString(lastDayCapital);
    }
//  用户提现操作
    @RequestMapping(value = "/addWithdraw")
    @ResponseBody
    public String addWithdraw(String id,String money, HttpServletRequest request){
        int result = fundService.addWithdraw(Integer.valueOf(id).intValue(),Double.valueOf(money));
        return result+"";
    }


}
