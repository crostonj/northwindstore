package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.OrderDetail;
import com.cloud.northwindstore.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public List<OrderDetail> GetOrderDetail(int OrderId) {

        orderDetailRepository.findByDiscountAndPAndProductID();
        return orderDetailRepository.GetOrderDetail(OrderId);
    }
}
