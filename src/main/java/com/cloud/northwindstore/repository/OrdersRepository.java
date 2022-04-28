package com.cloud.northwindstore.repository;

import com.cloud.northwindstore.model.Employee;
import com.cloud.northwindstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
    List<Order> findByEmployeeID(Employee employee);
}
