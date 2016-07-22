package com.onlinestore.dao.implement;

import com.onlinestore.dao.CartItemDao;
import com.onlinestore.model.Cart;
import com.onlinestore.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */
@SuppressWarnings("ALL")
@Repository
@Transactional
public class CartItemDaoimpl implements CartItemDao {


    @Autowired
    private SessionFactory sessionFactory;


    public void addCartItem(CartItem cartItem) {


        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(cartItem);


        session.flush();

    }

    public void removeCartItem(CartItem cartItem) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);

        session.flush();

    }

    public void readAllCartItem(Cart cart) {

        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItemt : cartItems) {

            removeCartItem(cartItemt);


        }


    }

    public CartItem getCartItemProductId(int productId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from CartItem where productId=?");

        query.setInteger(0, productId);

        session.flush();

        return (CartItem) query.uniqueResult();


    }
}
