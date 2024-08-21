package com.example.resource;

import com.example.dto.ClientPostDTO;
import com.example.entity.Client;
import com.example.service.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    public Response getClients() {
        return Response.ok(clientService.getClients()).build();
    }

    @GET
    @Path("/{id}")
    public Response getClientById(@PathParam("id") Long id) {
        return Response.ok(clientService.getClient(id)).build();
    }

    @POST
    public Response createClient(ClientPostDTO client) {
        return Response.ok(clientService.createClient(client)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateClient(@PathParam("id") Long id, ClientPostDTO client) {
        return Response.ok(clientService.updateClient(id, client)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Long id) {
        if (clientService.deleteClient(id)) {
            return Response.ok("Client delete with id: "+id+" successful").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
