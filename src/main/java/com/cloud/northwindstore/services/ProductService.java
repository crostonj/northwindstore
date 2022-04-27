package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> GetProductSearch(String name);
    Product GetProductById(Integer Id);
    List<Product> GetAllProducts();
}
