package com.example.resource;


import com.example.dto.ProductPostDTO;
import com.example.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    @Inject
    ProductService productService;

    @GET
    public Response getProducts() {
        return Response.ok(productService.getProducts()).build();
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        return Response.ok(productService.getProduct(id)).build();
    }

    @POST
    public Response addProduct(ProductPostDTO productPostDTO) {
        return Response.ok(productService.createProduct(productPostDTO)).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateClient(@PathParam("id") Long id, ProductPostDTO productPostDTO) {
        return Response.ok(productService.updateProduct(id, productPostDTO)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Long id) {
        if (productService.deleteProduct(id)) {
            return Response.ok("Product delete with id: "+id+" successful").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
