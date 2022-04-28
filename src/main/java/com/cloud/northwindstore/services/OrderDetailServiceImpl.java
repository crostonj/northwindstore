package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.Order;
import com.cloud.northwindstore.model.OrderDetail;
import com.cloud.northwindstore.model.OrderDetailId;
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

        Order order = new Order();
        order.setId(OrderId);

        return orderDetailRepository.getOrderDetailByOrderID(OrderId);
    }
}
