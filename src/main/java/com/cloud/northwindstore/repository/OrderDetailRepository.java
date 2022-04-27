package com.cloud.northwindstore.repository;

import com.cloud.northwindstore.model.OrderDetail;
import com.cloud.northwindstore.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

    @Query( value = "Select od from OrderDetail od where od.orderID = :orderId")
     List<OrderDetail> GetOrderDetail(@Param("orderId") Integer OrderId);

}
