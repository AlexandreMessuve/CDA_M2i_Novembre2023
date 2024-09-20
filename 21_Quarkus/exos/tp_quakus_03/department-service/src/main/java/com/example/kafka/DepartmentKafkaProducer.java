package com.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class DepartmentKafkaProducer {

    @Inject
    @Channel("department-deleted")
    Emitter<String> departmentDeletedEmitter;

    public void publishDepartmentDeletedEvent(Long departmentId) {
        String message = "Department " + departmentId + " deleted";
        departmentDeletedEmitter.send(message);
    }
}
