package com.onlinestore.dao.implement;

import com.onlinestore.dao.ProductDao;
import com.onlinestore.model.Product;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 22-Jun-16.
 */




@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;



    public List<Product> getAllProduct() {


        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Product");

        List<Product> productList = query.list();

        return productList;
    }

    public Product getProductById(int productId) {

        Session session = sessionFactory.getCurrentSession();

        Product product = (Product) session.get(Product.class, productId);

        session.flush();


        return product;
    }


    public void addProduct(Product product) {


        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(product);

        session.flush();

    }

    public void editProduct(Product product) {


        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(product);

        session.flush();

    }

    public void deleteProduct(Product product) {


        Session session = sessionFactory.getCurrentSession();

        session.delete(product);

        session.flush();


    }


}
