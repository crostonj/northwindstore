package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> GetAll();
    Optional<Customer> GetById(String id);
    Customer UpdateCuster(Customer customer);
}
