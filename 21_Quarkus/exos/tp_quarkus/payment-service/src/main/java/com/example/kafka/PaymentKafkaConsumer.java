package com.example.kafka;

import com.example.repository.PaymentRepository;
import com.example.service.PaymentService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PaymentKafkaConsumer {
    @Inject
    PaymentService paymentService;

    @Incoming("order-created")
    @Blocking
    public void consume(String message) {
        System.out.println("Received message: " + message);
        Long orderId = parseOrderIdFromMessage(message);
        String status = parseStatusFromMessage(message);
        Long clientId = parseClientIdFromMessage(message);
        double amount = parseAmountFromMessage(message);
        paymentService.processPayment(orderId, status, clientId, amount);
    }

    private Long parseOrderIdFromMessage(String message) {
        // Extract the orderId from the message
        // Example: "Order 1001 created"
        String[] parts = message.split(" ");
        return Long.parseLong(parts[1]);
    }
    private String parseStatusFromMessage(String message) {
        // Extract the status from the message
        // Example: "Order 1001 created"
        String[] parts = message.split(" ");
        return parts[3];
    }
    private Long parseClientIdFromMessage(String message) {
        // Extract the clientId from the message
        // Example: "Order 1001 created"
        String[] parts = message.split(" ");
        return Long.parseLong(parts[5]);
    }
    private double parseAmountFromMessage(String message) {
        // Extract the amount from the message
        // Example: "Order 1001 created"
        String[] parts = message.split(" ");
        return Double.parseDouble(parts[7]);
    }
}
