package com.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class EmployeeKafkaProducer {

    @Inject
    @Channel("employee-created")
    Emitter<String> employeeCreatedEmitter;

    @Inject
    @Channel("employee-deleted")
    Emitter<String> employeeDeletedEmitter;

    public void publishEmployeeCreatedEvent(Long employeeId, Long organizationId) {
        String message = "Employee " + employeeId + " organizationId " + organizationId;
        employeeCreatedEmitter.send(message);
    }

    public void publishEmployeeDeletedEvent(Long employeeId, Long organizationId) {
        String message = "Employee " + employeeId + " organizationId " + organizationId;
        employeeDeletedEmitter.send(message);
    }
}
