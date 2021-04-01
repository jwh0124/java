package com.circle.demo.customer.service;

import com.circle.demo.customer.domain.Customer;
import com.circle.demo.customer.domain.User;

import java.util.List;


public interface CustomerService {

    List<Customer> findAll();

    Customer findOne(Integer customerId);

    Customer create(Customer customer, User user);

    Customer update(Customer customer, User user);

    void delete(Integer customerId);
}
