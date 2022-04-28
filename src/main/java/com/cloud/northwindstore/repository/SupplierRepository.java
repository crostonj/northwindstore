package com.cloud.northwindstore.repository;

import com.cloud.northwindstore.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}