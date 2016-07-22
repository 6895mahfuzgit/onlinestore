package com.onlinestore.dao;

import com.onlinestore.model.Cart;
import com.onlinestore.model.CartItem;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */
public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void readAllCartItem(Cart cart);

    CartItem getCartItemProductId(int productId);
}
