package com.cykj.marketadmin.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.AdminService;
import com.cykj.marketadmin.service.FundService;
import com.cykj.marketpojo.DeliverymanFund;
import com.cykj.marketpojo.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("deliveryFundControl")
public class DeliveryFundControl {

    @Autowired
    private FundService fundService;

    @RequestMapping(value = "/findFundList")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String findFundList(HttpServletRequest request, HttpServletResponse response) {
        LayData layuiData = new LayData();
        layuiData = fundService.findFundList();
        return JSON.toJSONString(layuiData);
    }

    @RequestMapping(value = "/examine")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public void examine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String serial = request.getParameter("out_trade_no");
        System.out.println(serial);

        fundService.updateState(serial);
         response.sendRedirect("/menuControl/getMenu");
//        return out_trade_no;
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        String state = request.getParameter("state");
//        if (fundService.examine(id, state)) {
//            return "success";
//        } else {
//            return "fail";
//        }
    }

//    @RequestMapping(value = "/examine")
//    @ResponseBody
//    public String examine(Model model,HttpServletRequest request, HttpServletResponse response) {
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        String state = request.getParameter("state");
//        DeliverymanFund deliverymanFund=fundService.examine(id, state);
//        return "redirect:/alipay/index?WIDout_trade_no="+deliverymanFund.getSerial()+"&WIDtotal_amount="+deliverymanFund.getIncome()
//                +"&WIDsubject="+deliverymanFund.getSerial()+"&WIDbody="+"";
//    }

    @RequestMapping(value = "/unExamine")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String unExamine(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String state = request.getParameter("state");
        if (fundService.unExamine(id, state)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
