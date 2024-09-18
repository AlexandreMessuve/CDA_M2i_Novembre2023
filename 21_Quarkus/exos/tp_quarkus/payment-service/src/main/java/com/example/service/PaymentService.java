package com.example.service;

import com.example.client.AccountServiceClient;
import com.example.dto.PaymentDto;
import com.example.entity.Payment;
import com.example.kafka.PaymentKafkaProducer;
import com.example.repository.PaymentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PaymentService {

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    @RestClient
    AccountServiceClient accountServiceClient;

    @Inject
    PaymentKafkaProducer paymentProducer;

    public Payment getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Transactional
    public void processPayment(Long orderId, String status, Long clientId, double amount) {
        try {
            Payment payment = Payment.builder()
                    .status(status)
                    .amount(amount)
                    .orderId(orderId)
                    .build();
            paymentRepository.persist(payment);
            paymentProducer.publishPaymentCreatedEvent(payment.getId(), payment.getOrderId(), payment.getAmount(), payment.getStatus());
            String response = accountServiceClient.debitAccount(new PaymentDto(clientId, amount));
            if (response.equals("Payment successful")) {
                payment.setStatus("COMPLETED");
            } else {
                payment.setStatus("FAILED");
            }
            changeStatus(payment);
            paymentProducer.publishPaymentProcessedEvent(payment.getId(), payment.getOrderId(), payment.getStatus());
        } catch (Exception e) {
            System.out.println("Error processing payment: " + e.getMessage());
            throw e;
        }
    }

    @Transactional
    public void changeStatus(Payment payment) {
        paymentRepository.persist(payment);
    }
}