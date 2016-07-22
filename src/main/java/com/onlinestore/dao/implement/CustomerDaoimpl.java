package com.onlinestore.dao.implement;

import com.onlinestore.dao.CustomerDao;
import com.onlinestore.model.Authorities;
import com.onlinestore.model.Cart;
import com.onlinestore.model.Customer;
import com.onlinestore.model.Users;
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
public class CustomerDaoimpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void addCustomer(Customer customer) {


        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);


    


        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());


        /*********Creating Users  ***********/

        Users newUsers = new Users();

        newUsers.setUsername(customer.getUsername());
        newUsers.setPassword(customer.getPassword());
        newUsers.setEnabled(true);
        newUsers.setCustomerId(customer.getCustomerId());


        /***********Giving authoriting**********/

        Authorities newAuthorities = new Authorities();

        newAuthorities.setUsername(customer.getUsername());
        newAuthorities.setAuthoritiesId(customer.getCustomerId());
        newAuthorities.setAuthority("ROLE_USER");


        session.saveOrUpdate(newUsers);
        session.saveOrUpdate(newAuthorities);


        /************* Creating  Cart    *******************/

        Cart newCart = new Cart();
        newCart.setCustomer(customer);


        /****** adding cart to customer ******/
        customer.setCart(newCart);

        /***  here customer id and other are aready set top so only save customer***/
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);


        session.flush();
    }

    public Customer getCustomerById(int customerId) {


        Session session = sessionFactory.getCurrentSession();


        return (Customer) session.get(Customer.class, customerId);


    }

    public Customer getCustomerByUserName(String username) {
        Session session = sessionFactory.getCurrentSession();


        Query query = session.createQuery("from Customer where username=?");

        query.setString(0, username);

        return (Customer) query.uniqueResult();


    }

    public List<Customer> getAllCustomer() {


        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Customer");

        List<Customer> customerList = query.list();


        return customerList;
    }
}
