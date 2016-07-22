package com.onlinestore.service.Impl;

import com.onlinestore.dao.CartItemDao;
import com.onlinestore.model.Cart;
import com.onlinestore.model.CartItem;
import com.onlinestore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */

@Service
public class CartItemServiceimpl implements CartItemService {


    @Autowired
    protected CartItemDao cartItemDao;


    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);

    }

    public void removeCartItem(CartItem cartItem) {

        cartItemDao.removeCartItem(cartItem);

    }

    public void readAllCartItem(Cart cart) {


        cartItemDao.readAllCartItem(cart);

    }

    public  CartItem getCartItemProductId(int productId) {

       return cartItemDao.getCartItemProductId(productId);

    }
}
