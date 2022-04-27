package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.Order;

public interface OrderService {
    public abstract void saveOrder(Order order);
}
