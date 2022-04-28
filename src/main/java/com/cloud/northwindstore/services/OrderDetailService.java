package com.cloud.northwindstore.services;

import com.cloud.northwindstore.model.OrderDetail;
import com.cloud.northwindstore.model.OrderDetailId;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> GetOrderDetail(int OrderId);
}
