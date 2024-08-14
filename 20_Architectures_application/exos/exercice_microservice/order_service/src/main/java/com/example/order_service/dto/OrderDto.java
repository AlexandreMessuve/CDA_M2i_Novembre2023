package com.example.order_service.dto;


import com.example.order_service.entity.User;

public class OrderDto {
    private int orderId;
    private User user;
    private String productName;

    public OrderDto(int orderId, User user, String productName) {
        this.orderId = orderId;
        this.user = user;
        this.productName = productName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
