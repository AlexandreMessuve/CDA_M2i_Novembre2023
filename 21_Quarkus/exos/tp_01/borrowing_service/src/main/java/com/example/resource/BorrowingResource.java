package com.example.resource;

import com.example.dto.BorrowingPostDto;
import com.example.service.BorrowingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.time.LocalDate;

@Path("/borrowings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BorrowingResource {
    @Inject
    BorrowingService borrowingService;

    @GET
    public Response getAllBorrowings() {
        return Response.ok(borrowingService.getBorrowings()).build();
    }
    @GET
    @Path("/active")
    public Response getAllActiveBorrowings() {
        return Response.ok(borrowingService.getActiveBorrowings()).build();
    }
    @GET
    @Path("/interval")
    public Response getIntervalBorrowings(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate) {
        try {
            return Response.ok(borrowingService.getIntervalBorrowings(LocalDate.parse(startDate), LocalDate.parse(endDate))).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date format").build();
        }
    }

    @GET
    @Path("/search")
    public Response searchBorrowings(@QueryParam("userId") Long userId, @QueryParam("bookId") Long bookId) {
        if (userId != null) {
            return Response.ok(borrowingService.getBorrowingsByUserId(userId)).build();
        } else if (bookId != null) {
            return Response.ok(borrowingService.getBorrowingsByBookId(bookId)).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid query parameter").build();
        }
    }

    @GET
    @Path("/isBookBorrowing")
    public Response isBookBorrowing(@QueryParam("bookId") Long bookId) {
        String result = borrowingService.isBookBorrowing(bookId) ? "Book is borrowing" : "Book is not borrowing";
        return Response.ok(result).build();
    }
    @GET
    @Path("/{id}")
    public Response getBorrowingById(@PathParam("id") Long id) {
        return Response.ok(borrowingService.getBorrowingById(id)).build();
    }

    @POST
    @Path("/add")
    public Response addBorrowing(BorrowingPostDto borrowingPostDto) {
        return Response.ok(borrowingService.addBorrowing(borrowingPostDto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBorrowing(@PathParam("id") Long id, BorrowingPostDto borrowingPostDto) {
        return Response.ok(borrowingService.updateBorrowing(id, borrowingPostDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBorrowing(@PathParam("id") Long id) {
        if (borrowingService.deleteBorrowing(id)) {
            return Response.ok("Borrowing delete successful").build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
