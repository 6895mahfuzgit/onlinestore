package com.onlinestore.service;

import com.onlinestore.model.Product;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 24-Jun-16.
 */
public interface ProductService {


    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);


    List<Product> getAllProduct();

    Product getProductById(int productId);

}
