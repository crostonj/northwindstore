package com.cloud.northwindstore.controllers;

import com.cloud.northwindstore.model.*;
import com.cloud.northwindstore.repository.OrdersRepository;
import com.cloud.northwindstore.services.OrderService;
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
public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getallOrders(){

        List<Order> orders = new ArrayList<Order>();
        try {
            ordersRepository.findAll().forEach(orders::add);
            if(orders.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrdersById(@PathVariable("id") Integer id){
        Optional<Order> orderData = ordersRepository.findById(id);
        if(orderData.isPresent()){
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orders/employee/{id}")
    public ResponseEntity<List<Order>> findByEmployeeID(@PathVariable("id") Integer id){
        try{
            Employee employee = new Employee();
            employee.setId(id);
            List<Order> orders = ordersRepository.findByEmployeeID(employee);

            if(orders.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> updateOrder(Order order){
        try {
            orderService.saveOrder(order);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
