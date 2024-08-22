package com.example.resource;

import com.example.dto.AuthorPostDto;
import com.example.entity.Author;
import com.example.service.AuthorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/authors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {
    @Inject
    AuthorService authorService;

    @GET
    public Response getAllAuthors() {
        return Response.ok(authorService.getAuthorList()).build();
    }

    @GET
    @Path("/detail")
    public Response getAllAuthorsDetail(){
        return Response.ok(authorService.getAuthorDetailList()).build();
    }

    @GET
    @Path("/detail/{id}")
    public Response getAuthorDetail(@PathParam("id") Long id){
        return Response.ok(authorService.getAuthorDetail(id)).build();
    }
    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") Long id) {
        return Response.ok(authorService.getAuthorById(id)).build();
    }

    @GET
    @Path("/search")
    public Response getAuthorSearch(@QueryParam("name") String name, @QueryParam("prefixName") String prefixName){
        if(prefixName != null && !prefixName.isEmpty()){
            return Response.ok(authorService.getAuthorByPrefixName(prefixName)).build();
        }
        if(name != null && !name.isEmpty()){
            return Response.ok(authorService.getAuthorByName(name)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }
    @GET
    @Path("/detail/search")
    public Response getAuthorDetailSearch(@QueryParam("name") String name, @QueryParam("prefixName") String prefixName){
        if(prefixName != null && !prefixName.isEmpty()){
            return Response.ok(authorService.getAuthorDetailByPrefixName(prefixName)).build();
        }
        if(name != null && !name.isEmpty()){
            return Response.ok(authorService.getAuthorDetailByName(name)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }
    @POST
    @Path("/add")
    public Response addAuthor(AuthorPostDto authorPostDto) {
        return Response.ok(authorService.addAuthor(authorPostDto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") Long id, AuthorPostDto authorPostDto) {
        return Response.ok(authorService.updateAuthor(id, authorPostDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") Long id) {
        return Response.ok(authorService.deleteAuthor(id)).build();
    }

}
