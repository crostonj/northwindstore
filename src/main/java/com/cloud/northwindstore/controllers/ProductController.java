package com.cloud.northwindstore.controllers;


import com.cloud.northwindstore.model.Product;
import com.cloud.northwindstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *
     * @return
     */
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> products = new ArrayList<>();
        try {
           productService.GetAllProducts().forEach(products::add);
           if(products.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return  new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id){
        try {
            Optional<Product> product = Optional.ofNullable(productService.GetProductById(id));
            if(product.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
