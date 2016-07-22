package com.onlinestore.service.Impl;

import com.onlinestore.dao.ProductDao;
import com.onlinestore.model.Product;
import com.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 24-Jun-16.
 */

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductDao productDao;


    public void addProduct(Product product) {

        productDao.addProduct(product);

    }

    public void editProduct(Product product) {

        productDao.editProduct(product);

    }

    public void deleteProduct(Product product) {

        productDao.deleteProduct(product);
    }

    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    public Product getProductById(int productId) {

        return productDao.getProductById(productId);
    }
}
