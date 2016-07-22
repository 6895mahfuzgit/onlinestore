package com.onlinestore.service.Impl;

import com.onlinestore.dao.CustomerOrderDao;
import com.onlinestore.model.Cart;
import com.onlinestore.model.CartItem;
import com.onlinestore.model.CustomerOrder;
import com.onlinestore.service.CartService;
import com.onlinestore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 26-Jun-16.
 */
@Service
public class CustomerOrderServiceimpl implements CustomerOrderService {


    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderDao customerOrderDao;




    public void addCustomerOredr(CustomerOrder customerOrder) {


        customerOrderDao.addCustomerOredr(customerOrder);


    }

    public double getCustomerOrderGrandTotal(int cartId) {

        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }
}
