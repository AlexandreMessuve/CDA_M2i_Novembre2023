package com.example.order_service.dto;


public class OrderDto {
    private int orderId;
    private UserDto user;
    private String productName;

    public OrderDto(int orderId, UserDto user, String productName) {
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto userDto) {
        this.user = userDto;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
