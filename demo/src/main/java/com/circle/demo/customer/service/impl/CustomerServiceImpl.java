package com.circle.demo.customer.service.impl;

import com.circle.demo.customer.domain.Customer;
import com.circle.demo.customer.domain.User;
import com.circle.demo.customer.repository.CustomerRepository;
import com.circle.demo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Customer create(Customer customer, User user) {
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer, User user) {
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
