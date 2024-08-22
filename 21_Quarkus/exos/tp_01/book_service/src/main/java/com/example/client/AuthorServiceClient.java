package com.example.client;

import com.example.dto.AuthorDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/authors")
@RegisterRestClient(configKey = "author_service")
public interface AuthorServiceClient {
    @GET
    @Path("/{id}")
    AuthorDto getAuthor(@PathParam("id")Long id);
}
