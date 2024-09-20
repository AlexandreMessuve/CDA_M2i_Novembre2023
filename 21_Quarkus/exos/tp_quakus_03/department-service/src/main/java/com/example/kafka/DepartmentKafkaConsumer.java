package com.example.kafka;

import com.example.service.DepartmentService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class DepartmentKafkaConsumer {

    @Inject
    DepartmentService departmentService;

    @Incoming("organization-deleted")
    @Blocking
    @Transactional
    public void consumeOrganizationDeleted(String message) {
        Long organizationId = parseOrganizationIdFromMessage(message);
        departmentService.deleteOrganizationInDepartment(organizationId);
    }

    private Long parseOrganizationIdFromMessage(String message) {
        // Extract the organizationId from the message
        // Example: "Organization 1001 deleted"
        String[] parts = message.split(" ");
        return Long.parseLong(parts[1]);
    }
}
