package com.onlinestore.controller;

import com.onlinestore.model.Product;
import com.onlinestore.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by MahfuzCSE'11 on 24-Jun-16.
 */

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model) {

        List<Product> products = productService.getAllProduct();

        model.addAttribute("products", products);


        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable("productId") int productId, Model model) throws IOException {

        Product product = productService.getProductById(productId);

        model.addAttribute("product", product);

        return "viewProduct";

    }


}
