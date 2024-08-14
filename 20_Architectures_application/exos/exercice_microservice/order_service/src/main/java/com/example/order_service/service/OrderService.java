package com.example.order_service.service;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.Order;
import com.example.order_service.entity.User;
import com.example.order_service.repository.OderRepository;
import com.example.order_service.restuser.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OderRepository orderRepository;
    private final UserService userService;
    public OrderService(OderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orderList = (List<Order>) orderRepository.findAll();
        if (orderList.isEmpty()) {
            return List.of();
        }
        return orderList.stream()
                .map(this::orderToOrderDto).toList();
    }
    public OrderDto getOrderById(int id) {
        Order order =  orderRepository.findById(id).orElse(null);
        if (order != null) {
            return orderToOrderDto(order);
        }
        return null;
    }
    public OrderDto saveOrder(Order order) {
        return orderToOrderDto(orderRepository.save(order));
    }
    public List<OrderDto> getOrdersByUserId(int userId) {
        return orderRepository.findByUserId(userId).stream().map(this::orderToOrderDto).toList();
    }

    private OrderDto orderToOrderDto(Order order) {
        User user = userService.getUser(order.getUserId());
        return new OrderDto(order.getId(), user, order.getProduct());
    }
}
