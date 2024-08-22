package com.example.repository;

import com.example.entity.Review;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ReviewRepository implements PanacheRepository<Review> {
    public List<Review> findByRating(int rating) {
        return list("rating", rating);
    }
}
