package com.cloud.northwindstore.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "OrderDetail")
@Table(name = "\"Order Details\"", indexes = {
        @Index(name = "OrdersOrder_Details", columnList = "OrderID"),
        @Index(name = "ProductsOrder_Details", columnList = "ProductID")
})
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @MapsId("orderID")
    @JoinColumn(name = "OrderID", nullable = false)
    private Integer orderID;

    @MapsId("productID")
    @JoinColumn(name = "ProductID", nullable = false)
    private Integer productID;

    @Column(name = "UnitPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Discount", nullable = false)
    private Double discount;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }
}