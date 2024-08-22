package com.example.service;

import com.example.client.BookServiceClient;
import com.example.client.UserServiceClient;
import com.example.dto.ReviewGetDto;
import com.example.dto.ReviewPostDto;
import com.example.entity.Review;
import com.example.repository.ReviewRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class ReviewService {
    @Inject
    ReviewRepository reviewRepository;

    @Inject
    @RestClient
    BookServiceClient bookServiceClient;

    @Inject
    @RestClient
    UserServiceClient userServiceClient;

    public List<ReviewGetDto> getAllReviews() {
        return reviewRepository.findAll().stream()
            .map(this::reviewToReviewGetDto)
            .toList();
    }

    public List<ReviewGetDto> getReviewByUserName(String name){
        return getAllReviews().stream()
            .filter(reviewGetDto -> reviewGetDto.getUser().getName().equals(name))
            .toList();
    }

    public List<ReviewGetDto> getReviewByRating(int rating){
        return reviewRepository.findByRating(rating).stream()
            .map(this::reviewToReviewGetDto)
            .toList();
    }

    public List<ReviewGetDto> getReviewByIsbn(String isbn){
        return getAllReviews().stream()
            .filter(reviewGetDto -> reviewGetDto.getBook().getIsbn().equals(isbn))
            .toList();
    }

    public ReviewGetDto getReviewById(Long id) {
        return reviewToReviewGetDto(findReviewById(id));
    }

    @Transactional
    public ReviewGetDto createReview(ReviewPostDto reviewPostDto) {
        Review review = reviewDtoToReview(reviewPostDto);
        reviewRepository.persistAndFlush(review);
        if (reviewRepository.isPersistent(review)) {
            return reviewToReviewGetDto(review);
        }
        return null;
    }

    @Transactional
    public ReviewGetDto updateReview(Long id, ReviewPostDto reviewPostDto) {
        Review review = findReviewById(id);
        if (review != null) {
            review.setComment(reviewPostDto.getComment());
            review.setRating(reviewPostDto.getRating());
            review.setBookId(reviewPostDto.getBookId());
            review.setUserId(reviewPostDto.getUserId());
            reviewRepository.persistAndFlush(review);
            if (reviewRepository.isPersistent(review)) {
                return reviewToReviewGetDto(review);
            }

        }
        return null;
    }

    @Transactional
    public boolean deleteReview(Long id) {
        return reviewRepository.deleteById(id);
    }

    private Review findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    private Review reviewDtoToReview(ReviewPostDto reviewPostDto){
        Review review = new Review();
        review.setComment(reviewPostDto.getComment());
        review.setRating(reviewPostDto.getRating());
        review.setBookId(reviewPostDto.getBookId());
        review.setUserId(reviewPostDto.getUserId());
        return review;
    }

    private ReviewGetDto reviewToReviewGetDto(Review review){
        return new ReviewGetDto(
            review.getId(),
            review.getComment(),
            review.getRating(),
            bookServiceClient.findBookDetailById(review.getBookId()),
            userServiceClient.findUser(review.getUserId())
        );
    }

}
