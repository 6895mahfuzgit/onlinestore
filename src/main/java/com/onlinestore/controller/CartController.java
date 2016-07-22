package com.onlinestore.controller;

import com.onlinestore.model.Customer;
import com.onlinestore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */


@Controller
@RequestMapping("/customer/cart")
public class CartController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser) {

        Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());


        int cartId = customer.getCart().getCartId();


        return "redirect:/customer/cart/"+cartId;


    }



    @RequestMapping("/{cartId}")

    public String getCart(@PathVariable("cartId") int cartId ,Model model){


        model.addAttribute("cartId",cartId);

        return "cart";



    }








}
