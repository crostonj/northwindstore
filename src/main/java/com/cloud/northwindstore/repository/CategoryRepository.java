package com.cloud.northwindstore.repository;

import com.cloud.northwindstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}