package com.cloud.northwindstore.repository;

import com.cloud.northwindstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
