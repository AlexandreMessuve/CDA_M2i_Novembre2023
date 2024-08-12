package com.example.library_aspect.service;

import com.example.library_aspect.annotation.Log;
import com.example.library_aspect.annotation.Performance;
import com.example.library_aspect.entity.Book;
import com.example.library_aspect.entity.Loan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BookService {
    private final HashMap<Integer, Book> books;
    private final HashMap<Integer,Loan> loans;
    public BookService() {
        books = new HashMap<>();
        loans = new HashMap<>();
    }
    @Log
    @Performance
    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }
    @Log
    @Performance
    public Book getBook(int id) {
        return books.get(id);
    }
    @Log
    @Performance
    public List<Loan> getLoans() {
        return new ArrayList<>(loans.values());
    }
    @Log
    @Performance
    public Loan getLoan(int id) {
        return loans.get(id);
    }
    @Log
    @Performance
    public void addBook(String title, String author) {
        int bookId = books.size() + 1;
        Book book = Book.builder().id(bookId).title(title).author(author).build();
        books.put(bookId, book);
    }
    @Log
    @Performance
    public boolean loanBook(LocalDate startDate, LocalDate endDate, int bookId) {
        Book book = books.get(bookId);
        int loanId = loans.size() + 1;
        if (book != null && !book.isLoan()) {
            book.setLoan(true);
            Loan loan = Loan.builder().id(loanId).loanStartDate(startDate).loanEndDate(endDate).book(book).build();
            loans.put(loanId, loan);
            books.replace(bookId, book);
            return true;
        }
        return false;
    }
    @Log
    @Performance
    public boolean renderedBook(int loadId){
        Loan loan = loans.get(loadId);
        if (loan != null && !loan.isRendered()){
            loan.setRendered(true);
            Book book = loan.getBook();
            book.setLoan(false);
            loan.setBook(book);
            books.replace(book.getId(), book);
            loans.replace(loadId, loan);
            return true;
        }
        return false;
    }
}
