package com.onlinestore.service.Impl;

import com.onlinestore.dao.CartDao;
import com.onlinestore.model.Cart;
import com.onlinestore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;


    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void updateCart(Cart cart) {

        cartDao.updateCart(cart);

    }
}
