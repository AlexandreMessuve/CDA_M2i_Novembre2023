package com.example.resource;

import com.example.entity.Payment;
import com.example.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/payments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentResource {

    @Inject
    PaymentService paymentService;

    @GET
    @Path("/{id}")
    public Payment getPaymentByOrderId(@PathParam("id") Long orderId) {
        return paymentService.getPaymentByOrderId(orderId);
    }
}