package org.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class OrderKafkaProducer {

    @Inject
    @Channel("order-created")
    Emitter<String> orderCreatedEmitter;

    @Inject
    @Channel("order-updated")
    Emitter<String> orderUpdatedEmitter;

    public void publishOrderCreatedEvent(Long orderId, String status, Long clientId, double amount) {
        String message = "Order " + orderId + " status " + status + " clientId " + clientId + " amount " + amount;
        orderCreatedEmitter.send(message);
    }

    public void publishOrderUpdatedEvent(Long orderId, String newStatus) {
        String message = "Order " + orderId + " updated to status " + newStatus;
        orderUpdatedEmitter.send(message);
    }
}
