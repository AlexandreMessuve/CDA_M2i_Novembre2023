package com.example.library_aspect.controller;

import com.example.library_aspect.dto.BookDtoPost;
import com.example.library_aspect.entity.Book;
import com.example.library_aspect.entity.Loan;
import com.example.library_aspect.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> listAllBooks() {
        List<Book> bookList = bookService.getBooks();
        return ResponseEntity.ok(bookList);
    }
    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> listAllLoans() {
        List<Loan> loanList = bookService.getLoans();
        return ResponseEntity.ok(loanList);
    }
    @PostMapping("/book")
    public ResponseEntity<String> createBook(@RequestBody BookDtoPost book) {
        String title = book.getTitle();
        String author = book.getAuthor();
        bookService.addBook(title, author);
        return ResponseEntity.ok("Book created");
    }
}
