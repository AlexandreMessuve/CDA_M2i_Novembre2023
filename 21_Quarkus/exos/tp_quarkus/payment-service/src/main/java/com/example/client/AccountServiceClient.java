package com.example.client;

import com.example.dto.AccountDto;
import com.example.dto.PaymentDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/accounts")
@RegisterRestClient(configKey = "account-service")
public interface AccountServiceClient {
    @GET
    @Path("/{id}")
    AccountDto getAccountById(@PathParam("id") Long id);

    @GET
    @Path("/{id}/balance")
    double getAccountBalance(@PathParam("id") Long id);

    @POST
    @Path("/debit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    String debitAccount(PaymentDto paymentDto);

    @PUT
    @Path("/{id}/balance")
    void updateAccountBalance(@PathParam("id") Long id, double balance);

}
