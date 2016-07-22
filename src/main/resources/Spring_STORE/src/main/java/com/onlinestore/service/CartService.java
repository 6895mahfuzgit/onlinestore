package com.onlinestore.service;

import com.onlinestore.model.Cart;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */
public interface CartService {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);
}
