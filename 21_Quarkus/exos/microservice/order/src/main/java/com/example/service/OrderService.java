package com.example.service;

import com.example.client.ClientServiceClient;
import com.example.client.ProductServiceClient;
import com.example.dto.OrderGetDto;
import com.example.dto.OrderPostDto;
import com.example.entity.Order;
import com.example.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class OrderService {
    @Inject
    OrderRepository orderRepository;

    @Inject
    @RestClient
    ClientServiceClient clientServiceClient;

    @Inject
    @RestClient
    ProductServiceClient productServiceClient;

    public List<OrderGetDto> getOrders() {
        return orderRepository.findAll().stream().map(this::orderToGetDto).toList();
    }

    public OrderGetDto getOrder(Long id) {
        return orderToGetDto(getOrderById(id));
    }

    @Transactional
    public OrderGetDto createOrder(OrderPostDto orderPostDto) {
        Order order = orderDtoToOrder(orderPostDto);
        orderRepository.persistAndFlush(order);
        if (orderRepository.isPersistent(order)){
            return orderToGetDto(order);
        }else{
            return null;
        }
    }

    @Transactional
    public OrderGetDto updateOrder(Long id, OrderPostDto orderUpdated) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setQuantity(orderUpdated.getQuantity());
            order.setClientId(orderUpdated.getClientId());
            order.setProductId(orderUpdated.getProductId());
            orderRepository.persistAndFlush(order);
            if (orderRepository.isPersistent(order)){
                return orderToGetDto(order);
            }else{
                return null;
            }
        }
        return null;
    }

    @Transactional
    public boolean deleteOrder(Long id) {
        return orderRepository.deleteById(id);
    }

    private Order getOrderById(Long id){
        return orderRepository.findById(id);
    }

    private Order orderDtoToOrder(OrderPostDto orderPostDto){
        Order order = new Order();
        order.setQuantity(orderPostDto.getQuantity());
        order.setOrderDate(LocalDate.now());
        order.setClientId(orderPostDto.getClientId());
        order.setProductId(orderPostDto.getProductId());
        return order;
    }

    private OrderGetDto orderToGetDto(Order order){
        return new OrderGetDto(
                order.getId(),
                order.getQuantity(),
                order.getOrderDate(),
                productServiceClient.findProduct(order.getProductId()),
                clientServiceClient.getClient(order.getClientId())
        );
    }
}
