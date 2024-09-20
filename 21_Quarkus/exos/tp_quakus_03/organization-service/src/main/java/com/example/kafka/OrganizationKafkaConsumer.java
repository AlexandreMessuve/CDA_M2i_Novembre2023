package com.example.kafka;

import com.example.service.OrganizationService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class OrganizationKafkaConsumer {
    @Inject
    OrganizationService organizationService;

    @Incoming("employee-created")
    @Blocking
    @Transactional
    public void consumeEmployeeCreated(String message){
        System.out.println("Received message: " + message);
        Long organizationId = parseOrganizationIdFromMessage(message);

        organizationService.incrementNumberOfEmployees(organizationId);
    }

    @Incoming("employee-deleted")
    @Blocking
    @Transactional
    public void consumeEmployeeDeleted(String message){
        System.out.println("Received message: " + message);
        Long organizationId = parseOrganizationIdFromMessage(message);

        organizationService.decrementNumberOfEmployees(organizationId);
    }

    private Long parseOrganizationIdFromMessage(String message){
        // Extract the organizationId from the message
        // Example: "Employee 1001 organizationId 1002"
        String[] parts = message.split(" ");
        return Long.parseLong(parts[3]);
    }
}
