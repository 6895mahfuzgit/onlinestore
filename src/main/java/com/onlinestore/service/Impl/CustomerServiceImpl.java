package com.onlinestore.service.Impl;

import com.onlinestore.dao.CustomerDao;
import com.onlinestore.model.Customer;
import com.onlinestore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */

@Service
public class CustomerServiceImpl implements CustomerService{



    @Autowired
    private CustomerDao customerDao;


    public void addCustomer(Customer customer) {


        customerDao.addCustomer(customer);

    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public Customer getCustomerByUserName(String username) {
        return customerDao.getCustomerByUserName(username);
    }

    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }
}
