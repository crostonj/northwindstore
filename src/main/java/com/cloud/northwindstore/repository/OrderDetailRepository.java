package com.cloud.northwindstore.repository;

import com.cloud.northwindstore.model.Order;
import com.cloud.northwindstore.model.OrderDetail;
import com.cloud.northwindstore.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> getOrderDetailByOrderID (Integer order);
}
