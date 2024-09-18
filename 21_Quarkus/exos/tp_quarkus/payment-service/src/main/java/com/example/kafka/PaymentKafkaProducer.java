package com.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class PaymentKafkaProducer {

    @Inject
    @Channel("payment-created")
    Emitter<String> paymentCreatedEmitter;

    @Inject
    @Channel("payment-processed")
    Emitter<String> paymentProcessedEmitter;

    public void publishPaymentCreatedEvent(Long paymentId, Long orderId, double amount, String status) {
        String message = "Payment " + paymentId + " created for order " + orderId + " with amount " + amount + " and status " + status;
        paymentCreatedEmitter.send(message);
    }

    public void publishPaymentProcessedEvent(Long paymentId, Long orderId, String status) {
        String message = "Payment " + paymentId + " orderId " + orderId + " status " + status;
        paymentProcessedEmitter.send(message);
    }
}