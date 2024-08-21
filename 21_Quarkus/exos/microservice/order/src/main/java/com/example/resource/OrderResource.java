package com.example.resource;

import com.example.dto.OrderPostDto;
import com.example.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService orderService;

    @GET
    public Response getOrders() {
        return Response.ok(orderService.getOrders()).build();
    }

    @GET
    @Path("/{id}")
    public Response getOrder(@PathParam("id") Long id) {
        return Response.ok(orderService.getOrder(id)).build();
    }

    @POST
    public Response createOrder(OrderPostDto orderPostDto) {
        return Response.ok(orderService.createOrder(orderPostDto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateOrder(@PathParam("id") Long id, OrderPostDto orderPostDto) {
        return Response.ok(orderService.updateOrder(id, orderPostDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") Long id) {
        return Response.ok(orderService.deleteOrder(id)).build();
    }
}
