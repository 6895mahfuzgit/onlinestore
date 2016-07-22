package com.onlinestore.controller.admin;

import com.onlinestore.model.Customer;
import com.onlinestore.model.Product;
import com.onlinestore.service.CustomerService;
import com.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminhome() {

        return "admin";
    }


    @RequestMapping("productInventory")
    public String productInventory(Model model) {

        List<Product> products = productService.getAllProduct();

        model.addAttribute("products", products);


        return "productInventory";

    }


    @RequestMapping("/customer")
    public String customerManagement(Model model) {


        List<Customer> customerList = customerService.getAllCustomer();


        model.addAttribute("customerList",customerList);

        return "customerManagement";


    }


}
