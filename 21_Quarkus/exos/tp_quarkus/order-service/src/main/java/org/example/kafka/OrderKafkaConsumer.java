package org.example.kafka;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.example.service.OrderService;

@ApplicationScoped
public class OrderKafkaConsumer {

    @Inject
    OrderService orderService;

    @Incoming("payment-processed")
    @Blocking
    public void consume(String message) {
        Long orderId = parseOrderIdFromMessage(message);
        String newStatus = parseStatusFromMessage(message);
        orderService.updateOrderStatus(orderId, newStatus);
    }

    private Long parseOrderIdFromMessage(String message) {
        // Extract the orderId from the message
        // Example: "Order 1001 created"
        String[] parts = message.split(" ");
        return Long.parseLong(parts[3]);
    }

    private String parseStatusFromMessage(String message) {
        // Extract the status from the message
        // Example: "Order 1001 created"
        String[] parts = message.split(" ");
        return parts[5];
    }

}
