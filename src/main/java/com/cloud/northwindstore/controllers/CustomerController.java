package com.cloud.northwindstore.controllers;

import com.cloud.northwindstore.model.Customer;
import com.cloud.northwindstore.services.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;


    /**
     *
     * @return
     */
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> Get(){
        List<Customer> customers = new ArrayList<>();
        try {
            customerService.GetAll().forEach(customers::add);
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> GetById(@PathVariable("id") String id){
        Optional<Customer> customer;
        try{
            customer = customerService.GetById(id);
            if(customer.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }

    }


    @PostMapping("/customer")
    public ResponseEntity<Customer> UpdateCustomer(@RequestBody Customer customer){
        try {
            Optional<Customer> updateCustomer = Optional.ofNullable(customerService.UpdateCuster(customer));
            if (updateCustomer.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updateCustomer.get(), HttpStatus.OK);
        }
        catch (Exception ex){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customer")
    public ResponseEntity<Customer> NewCustomer(@RequestBody Customer customer){
        try {
            if(customerService.GetById(customer.getId()).isPresent()) {
                Optional<Customer> updateCustomer = Optional.ofNullable(customerService.UpdateCuster(customer));
                if (updateCustomer.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(updateCustomer.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
