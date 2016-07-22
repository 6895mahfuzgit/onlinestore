package com.onlinestore.service;

import com.onlinestore.model.CustomerOrder;

/**
 * Created by MahfuzCSE'11 on 26-Jun-16.
 */
public interface CustomerOrderService {



    void addCustomerOredr(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
