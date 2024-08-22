package com.example.client;

import com.example.dto.UserDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/users")
@RegisterRestClient(configKey = "user_service")
public interface UserServiceClient {
    @GET
    @Path("/{id}")
    UserDto findUser(@PathParam("id") Long id);
}
