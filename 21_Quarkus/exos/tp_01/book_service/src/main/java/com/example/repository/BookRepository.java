package com.example.repository;

import com.example.entity.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {
    public List<Book> findByAuthorId(Long authorId) {
        return find("authorId", authorId).list();
    }
    public List<Book> findByTitlePrefix(String prefix) {
        return find("title like ?1", prefix+"%").list();
    }
}
