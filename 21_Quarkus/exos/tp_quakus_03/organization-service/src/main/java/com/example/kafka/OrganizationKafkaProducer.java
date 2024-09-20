package com.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class OrganizationKafkaProducer {

    @Inject
    @Channel("organization-deleted")
    Emitter<String> organizationDeletedEmitter;

    public void publishOrganizationDeletedEvent(Long organizationId) {
        String message = "Organization " + organizationId + " deleted";
        organizationDeletedEmitter.send(message);
    }
}
