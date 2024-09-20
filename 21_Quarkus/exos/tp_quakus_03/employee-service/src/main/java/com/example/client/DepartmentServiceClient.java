package com.example.client;

import com.example.dto.DepartmentDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/departments")
@RegisterRestClient(configKey = "department-service")
public interface DepartmentServiceClient {
    @GET
    @Path("/{id}")
    DepartmentDto getDepartmentById(Long id);
}
