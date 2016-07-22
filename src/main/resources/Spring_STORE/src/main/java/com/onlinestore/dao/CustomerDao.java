package com.onlinestore.dao;

import com.onlinestore.model.Customer;

import java.util.List;

/**
 * Created by MahfuzCSE'11 on 25-Jun-16.
 */
public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);
    Customer getCustomerByUserName(String username);

    List<Customer> getAllCustomer();
}
