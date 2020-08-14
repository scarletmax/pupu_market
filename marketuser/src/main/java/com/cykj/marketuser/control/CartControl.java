package com.cykj.marketuser.control;

import com.alibaba.fastjson.JSON;
import com.cykj.marketpojo.Cart;
import com.cykj.marketuser.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cartControl")
public class CartControl {
    @Autowired
    private CartService cartService;

    @RequestMapping("addGoods")
    @ResponseBody
    public String addGoods(int goodsId,int userId,int shopId){
        Cart cart = new Cart(userId,goodsId,shopId);
        cart.setGoodsCount(1);
        cart.setChoiceProp("");
        return cartService.addGoods(cart);
    }
    @RequestMapping("showCart")
    @ResponseBody
    public String showCart(int userId,int shopId){
        return JSON.toJSONString(cartService.showCart(userId,shopId));
    }

}
