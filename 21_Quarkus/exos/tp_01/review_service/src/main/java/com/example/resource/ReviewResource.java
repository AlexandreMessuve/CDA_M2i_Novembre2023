package com.example.resource;

import com.example.dto.ReviewPostDto;
import com.example.service.ReviewService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/reviews")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewResource {

    @Inject
    ReviewService reviewService;


    @GET
    public Response getAllReview() {
        return Response.ok(reviewService.getAllReviews()).build();
    }

    @GET
    @Path("/{id}")
    public Response getReviewById(@PathParam("id") Long id) {
        return Response.ok(reviewService.getReviewById(id)).build();
    }

    @GET
    @Path("/book/{isbn}")
    public Response getReviewByIsbn(@PathParam("isbn") String isbn) {
        return Response.ok(reviewService.getReviewByIsbn(isbn)).build();
    }

    @GET
    @Path("/user/{name}")
    public Response getReviewByUserName(@PathParam("name") String name) {
        return Response.ok(reviewService.getReviewByUserName(name)).build();
    }

    @GET
    @Path("/rating/{rating}")
    public Response getReviewByRating(@PathParam("rating") int rating) {
        return Response.ok(reviewService.getReviewByRating(rating)).build();
    }

    @POST
    @Path("/add")
    public Response createReview(ReviewPostDto reviewPostDto) {
        return Response.ok(reviewService.createReview(reviewPostDto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateReview(@PathParam("id") Long id, ReviewPostDto reviewPostDto) {
        return Response.ok(reviewService.updateReview(id, reviewPostDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteReview(@PathParam("id") Long id) {
        if (reviewService.deleteReview(id)) {
            return Response.ok("Review delete successful").build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
