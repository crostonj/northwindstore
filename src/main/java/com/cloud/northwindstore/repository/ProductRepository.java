package com.cloud.northwindstore.repository;

import com.cloud.northwindstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
