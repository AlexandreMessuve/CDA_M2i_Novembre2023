package com.example.kafka;

import com.example.service.EmployeeService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class EmployeeKafkaConsume {

    @Inject
    EmployeeService employeeService;

    @Incoming("organization-deleted")
    @Blocking
    @Transactional
    public void consumeOrganizationDeleted(String message) {
        System.out.println("Received message: " + message);
        Long organizationId = parseOrganizationOrDepartmentIdFromMessage(message);

        employeeService.deleteOrganizationInEmployee(organizationId);
    }

    @Incoming("department-deleted")
    @Blocking
    @Transactional
    public void consumeDepartmentDeleted(String message) {
        System.out.println("Received message: " + message);
        Long departmentId = parseOrganizationOrDepartmentIdFromMessage(message);

        employeeService.deleteDepartmentInEmployee(departmentId);
    }

    private Long parseOrganizationOrDepartmentIdFromMessage(String message) {
        // Extract the organizationId from the message
        // Example: "Organization 1001 deleted"
        String[] parts = message.split(" ");
        return Long.parseLong(parts[1]);
    }
}
