package com.cloud.northwindstore.controllers;


import com.cloud.northwindstore.model.OrderDetail;
import com.cloud.northwindstore.repository.OrderDetailRepository;
import com.cloud.northwindstore.services.OrderDetailService;
import com.cloud.northwindstore.services.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderDetailController {

    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @GetMapping("/orderdetail/{id}")
    public ResponseEntity<List<OrderDetail>> get(@PathVariable("id")Integer id){
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            orderDetailService.GetOrderDetail(id).forEach(orderDetails::add);
            if(orderDetails.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);

        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
