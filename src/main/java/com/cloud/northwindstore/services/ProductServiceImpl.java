package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.Product;
import com.cloud.northwindstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    /**
     *
     * @return
     */
    @Override
    public List<Product> GetProductSearch(String name) {
        List<Product> products = new ArrayList<>();
        try{
            products = productRepository.findAll();

        }
        catch (Exception ex){
        }
        return products;
    }

    /**
     *
     * @param Id
     * @return
     */
    @Override
    public Product GetProductById(Integer Id) {
        return productRepository.getById(Id);
    }

    @Override
    public List<Product> GetAllProducts() {
        List<Product> products = new ArrayList<>();
        try{
            products = productRepository.findAll();

        }
        catch (Exception ex){
        }
        return products;
    }
}
