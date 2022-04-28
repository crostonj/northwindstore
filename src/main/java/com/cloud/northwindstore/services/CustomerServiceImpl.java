package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.Customer;
import com.cloud.northwindstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> GetAll() {
        return customerRepository.findAll();
    }
}
