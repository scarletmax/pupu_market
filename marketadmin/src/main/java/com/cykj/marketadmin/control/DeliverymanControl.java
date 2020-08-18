package com.cykj.marketadmin.control;
import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.aop.Log;
import com.cykj.marketadmin.service.DeliverymanService;

import com.cykj.marketpojo.Deliveryman;
import com.cykj.marketpojo.LayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@RequestMapping("deliverymanControl")
@Controller
public class DeliverymanControl {
    @Autowired
    private DeliverymanService deliverymanService;

    @RequestMapping("showTable")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
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
        //设置名字条件
        String name = request.getParameter("name");
        if (name != null && !name.trim().equals("")) {
            condition.put("name", name);
        }
        String account = request.getParameter("account");
        if (account != null && !account.trim().equals("")) {
            condition.put("account", account);
        }
        String state=request.getParameter("state");
        if (state != null && !state.trim().equals("")) {
            condition.put("state", state);
        }
        Integer pageSize = Integer.parseInt(request.getParameter("limit"));
        condition.put("pageSize", pageSize);
        condition.put("startNum", (curPage - 1) * pageSize);
        LayData<Deliveryman> deliverymanLayData = deliverymanService.showTable(condition);
        return JSON.toJSONString(deliverymanLayData);
    }

    @RequestMapping("updateState")
    @ResponseBody
    @Log(operationType = "操作",operationName = "审核派送员")
//    @Log(operationType = "操作",operationName = "审核派送员")
    //审核文件 修改状态
    public String updateState(int id,String state) throws IOException, ServletException {
        if (deliverymanService.updateState(id, state)) {
            return "success";
        } else {
            return "fail";
        }
    }
    @RequestMapping("getAllState")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String getAllState() {
        return JSON.toJSONString(deliverymanService.getAllState());
    }

    @RequestMapping("queryBenefit")
    @ResponseBody
    @Log(operationType = "查看",operationName = "")
    public String queryBenefit(){
        return deliverymanService.queryBenefit()+"";
    }

    @RequestMapping("setBenefit")
    @ResponseBody
    @Log(operationType = "操作",operationName = "设置派送员提成金额")
    public String setBenefit(String benefit){
        return deliverymanService.setBenefit(benefit);
    }


}
