package com.example.resource;

import com.example.dto.UserPostDto;
import com.example.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService userService;

    @GET
    public Response getUsers() {
        return Response.ok(userService.getAllUsers()).build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Long id) {
        return Response.ok(userService.getUserById(id)).build();
    }

    @POST
    @Path("/add")
    public Response addUser(UserPostDto userPostDto) {
        return Response.ok(userService.addUser(userPostDto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, UserPostDto userPostDto) {
        return Response.ok(userService.updateUser(id, userPostDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        if(userService.deleteUser(id)) {
            return Response.ok("User delete successful").build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
