package com.cykj.marketuser.service.impl;

import com.cykj.marketpojo.Cart;
import com.cykj.marketuser.mapper.CartMapper;
import com.cykj.marketuser.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override

    public String addGoods(Cart cart) {
        return cartMapper.addGoods(cart)>0?"success":"fail";
    }

    @Override
    public List<Cart> showCart(int userId, int shopId) {
        return cartMapper.showCart(userId,shopId);
    }

    @Override
    public String clearCart(int userId, int shopId) {
        return cartMapper.clearCart(userId,shopId)>0?"success":"fail";
    }

    @Override
    public String updateGoodsCount(int userId, int shopId, int index, int goodsCount) {
        int goodsId=cartMapper.getGoodsIdByIndex(userId,shopId,index);
        return cartMapper.updateGoodsCount(goodsCount,goodsId)>0 ?"success":"fail";
    }

    @Override
    public String deleteGoods(int id) {
        return cartMapper.deleteGoods(id)>0? "success":"fail";
    }
}
