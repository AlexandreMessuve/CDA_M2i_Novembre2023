package com.example.client;

import com.example.dto.ClientDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Collection;

@Path("/clients")
@RegisterRestClient(configKey = "client")
public interface ClientServiceClient {

    @GET
    @Path("/{id}")
    ClientDto getClient(@PathParam("id") Long id);

    @GET
    Collection<ClientDto> getAllClients();
}
