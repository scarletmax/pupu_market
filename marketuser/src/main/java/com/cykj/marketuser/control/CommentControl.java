package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.DeliverymanComment;
import com.cykj.marketpojo.GoodsComment;
import com.cykj.marketuser.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("commentControl")
public class CommentControl {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/comment")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public void comment(String dc, String gc ,HttpServletRequest request, HttpServletResponse response){
        DeliverymanComment deliverymanComment = JSON.parseObject(dc,DeliverymanComment.class);
        GoodsComment goodsComment = JSON.parseObject(gc,GoodsComment.class);
        try {
            commentService.insertComment(deliverymanComment,goodsComment);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }


}
