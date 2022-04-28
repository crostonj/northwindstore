package com.cloud.northwindstore.repository;

import com.cloud.northwindstore.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}