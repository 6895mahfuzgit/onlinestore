package com.onlinestore.dao;

import com.onlinestore.model.Cart;

import java.io.IOException;

/**
 * Created by MahfuzCSE'11 on 24-Jun-16.
 */
public interface CartDao {

    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void updateCart(Cart cart);
}
