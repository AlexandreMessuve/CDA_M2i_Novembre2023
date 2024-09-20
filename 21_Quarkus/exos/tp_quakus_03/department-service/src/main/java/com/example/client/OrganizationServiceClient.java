package com.example.client;

import com.example.dto.OrganizationDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
@Path("/organizations")
@RegisterRestClient(configKey = "organization-service")
public interface OrganizationServiceClient {
    @GET
    @Path("/{id}")
    OrganizationDto getOrganizationById(Long id);
}
