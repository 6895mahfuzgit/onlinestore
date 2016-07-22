package com.onlinestore.controller;

import com.onlinestore.model.Cart;
import com.onlinestore.model.Customer;
import com.onlinestore.model.CustomerOrder;
import com.onlinestore.service.CartService;
import com.onlinestore.service.CustomerOrderService;
import com.onlinestore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MahfuzCSE'11 on 26-Jun-16.
 */
@Controller
public class OrderController {


    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;


    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId) {

        CustomerOrder customerOrder = new CustomerOrder();

        Cart cart = cartService.getCartById(cartId);

        customerOrder.setCart(cart);


        Customer customer = cart.getCustomer();

        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());


        customerOrderService.addCustomerOredr(customerOrder);


        return "redirect:/checkout?cartId="+cartId;


    }
}
