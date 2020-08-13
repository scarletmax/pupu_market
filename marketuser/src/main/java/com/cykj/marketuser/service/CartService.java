package com.cykj.marketuser.service;

import com.cykj.marketpojo.Cart;

import java.util.List;

public interface CartService {
    String addGoods(Cart cart);
    List<Cart> showCart(int userId, int shopId);

}
