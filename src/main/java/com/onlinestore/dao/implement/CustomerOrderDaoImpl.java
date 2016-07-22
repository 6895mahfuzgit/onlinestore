package com.onlinestore.dao.implement;

import com.onlinestore.dao.CustomerOrderDao;
import com.onlinestore.model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MahfuzCSE'11 on 26-Jun-16.
 */
@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {


    @Autowired
    private SessionFactory sessionFactory;


    public void addCustomerOredr(CustomerOrder customerOrder) {


        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customerOrder);

        session.flush();

    }


}
