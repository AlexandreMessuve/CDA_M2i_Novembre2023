package com.example.resource;

import com.example.dto.BookPostDto;
import com.example.service.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookService bookService;

    @GET
    public Response getBookList() {
        return Response.ok(bookService.getBookList()).build();
    }
    @GET
    @Path("/detail")
    public Response getBookListDetail() {
        return Response.ok(bookService.getBookDetailedList()).build();
    }
    @GET
    @Path("/search")
    public Response getBookListSearch(@QueryParam("authorId") Long id, @QueryParam("title") String title) {
        if (id != null && id > 0) {
            return Response.ok(bookService.getBooksByAuthor(id)).build();
        }
        if (title != null && !title.isEmpty()) {
            return Response.ok(bookService.getBooksByTitlePrefix(title)).build();
        }
        return Response.noContent().build();
    }
    @GET
    @Path("/{id}")
    public Response getBook(@PathParam("id") Long id) {
        return Response.ok(bookService.getBook(id)).build();
    }
    @GET
    @Path("/detail/{id}")
    public Response getBookDetail(@PathParam("id") Long id) {
        return Response.ok(bookService.getBookDetailed(id)).build();
    }

    @POST
    @Path("/add")
    public Response addBook(BookPostDto bookPostDto) {
        return Response.ok(bookService.addBook(bookPostDto)).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") Long id, BookPostDto bookPostDto) {
        return Response.ok(bookService.updateBook(id, bookPostDto)).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        if (bookService.deleteBook(id)){
            return Response.ok("Book delete successful").build();
        }else{
            return Response.ok("Book delete failed").build();
        }
    }
}
