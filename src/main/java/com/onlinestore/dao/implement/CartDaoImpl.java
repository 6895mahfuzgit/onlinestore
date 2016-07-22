package com.onlinestore.dao.implement;

import com.onlinestore.dao.CartDao;
import com.onlinestore.model.Cart;
import com.onlinestore.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */

@Repository
@Transactional
public class CartDaoImpl implements CartDao {


    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    private CustomerOrderService  customerOrderService;


    public Cart getCartById(int cartId) {

        Session session = sessionFactory.getCurrentSession();


        return (Cart) session.get(Cart.class, cartId);
    }

    public Cart validate(int cartId) throws IOException {


        Cart cart = getCartById(cartId);


        if (cart == null || cart.getCartItems().size() == 0) {


            throw new IOException(cartId + "");


        }


        updateCart(cart);


        return cart;
    }

    public void updateCart(Cart cart) {

        int cartId = cart.getCartId();


        double groundTotal=customerOrderService.getCustomerOrderGrandTotal(cartId);

        cart.setGrandTotal(groundTotal);

        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);

        session.flush();

    }
}
