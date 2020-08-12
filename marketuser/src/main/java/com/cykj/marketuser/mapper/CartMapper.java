package com.cykj.marketuser.mapper;

import com.cykj.marketpojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {
    Integer addGoods(Cart cart);
    List<Cart> showCart(int userId, int shopId);
    Integer clearCart(@Param("userId") int userId, @Param("shopId") int shopId);
}
