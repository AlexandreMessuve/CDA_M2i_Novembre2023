package com.example.client;

import com.example.dto.BookDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/books")
@RegisterRestClient(configKey = "book_service")
public interface BookServiceClient {
    @GET
    @Path("/search")
    List<BookDto> searchBook(@QueryParam("authorId") Long authorId);

    @GET
    @Path("/{id}")
    BookDto getBook(@PathParam("id") Long id);
}
