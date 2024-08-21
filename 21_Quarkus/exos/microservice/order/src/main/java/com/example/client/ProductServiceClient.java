package com.example.client;

import com.example.dto.ProductDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Collection;

@Path("/products")
@RegisterRestClient(configKey = "product")
public interface ProductServiceClient {
    @GET
    @Path("/{id}")
    ProductDto findProduct(@PathParam("id") Long id);

    @GET
    Collection<ProductDto> findAllProducts();
}
