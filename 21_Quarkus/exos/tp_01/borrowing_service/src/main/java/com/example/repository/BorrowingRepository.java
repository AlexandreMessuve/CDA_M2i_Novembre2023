package com.example.repository;

import com.example.entity.Borrowing;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BorrowingRepository implements PanacheRepository<Borrowing> {
    public List<Borrowing> findByUserId(Long userId) {
        return find("userId", userId).list();
    }
    public List<Borrowing> findByBookId(Long bookId) {
        return find("bookId", bookId).list();
    }
}
