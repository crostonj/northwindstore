package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.Order;
import com.cloud.northwindstore.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void saveOrder(Order orders) {
        ordersRepository.save(orders);
    }
}
