package com.onlinestore.dao;

import com.onlinestore.model.Product;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 22-Jun-16.
 */


public interface ProductDao {

    List<Product> getAllProduct();

    Product getProductById(int productId);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);




}
