package com.example.client;

import com.example.dto.BookDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/books")
@RegisterRestClient(configKey = "book_service")
public interface BookServiceClient {
    @GET
    @Path("/detail/{id}")
    BookDto findBookDetailById(@PathParam("id") Long id);
}
