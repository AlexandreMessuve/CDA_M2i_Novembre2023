package com.example.order_service.repository;

import com.example.order_service.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OderRepository extends CrudRepository<Order, Integer> {
    List<Order> findByUserId(int userId);
}
