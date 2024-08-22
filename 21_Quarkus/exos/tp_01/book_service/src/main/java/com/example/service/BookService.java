package com.example.service;

import com.example.client.AuthorServiceClient;
import com.example.dto.BookGetDetailedDto;
import com.example.dto.BookGetDto;
import com.example.dto.BookPostDto;
import com.example.entity.Book;
import com.example.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class BookService {
    @Inject
    BookRepository bookRepository;

    @Inject
    @RestClient
    AuthorServiceClient authorServiceClient;

    public List<BookGetDetailedDto> getBookDetailedList(){
        return bookRepository.findAll().stream().map(this::bookToBookGetDetailedDto).toList();
    }
    public BookGetDetailedDto getBookDetailed(Long id){
        return bookToBookGetDetailedDto(findBookById(id));
    }

    public List<BookGetDto> getBookList() {
        return bookRepository.findAll().stream().map(this::bookToBookGetDto).toList();
    }
    public BookGetDto getBook(Long id) {
        return bookToBookGetDto(findBookById(id));
    }

    public List<BookGetDto> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId).stream().map(this::bookToBookGetDto).toList();
    }

    public List<BookGetDto> getBooksByTitlePrefix(String titlePrefix) {
        return bookRepository.findByTitlePrefix(titlePrefix).stream().map(this::bookToBookGetDto).toList();
    }

    @Transactional
    public BookGetDto addBook(BookPostDto bookPostDto) {
        Book book = bookDtoToBook(bookPostDto);
        bookRepository.persistAndFlush(book);
        if (bookRepository.isPersistent(book)){
            return bookToBookGetDto(book);
        }else{
            return null;
        }
    }
    @Transactional
    public BookGetDto updateBook(Long id,BookPostDto bookUpdate) {
        Book book = findBookById(id);
        if (book != null) {
            book.setTitle(bookUpdate.getTitle());
            book.setDescription(bookUpdate.getDescription());
            book.setIsbn(bookUpdate.getIsbn());
            book.setPublishDate(bookUpdate.getPublishDate());
            book.setAuthorId(bookUpdate.getAuthorId());
            bookRepository.persistAndFlush(book);
            if (bookRepository.isPersistent(book)){
                return bookToBookGetDto(book);
            }
        }
        return null;
    }

    @Transactional
    public boolean deleteBook(Long id) {
        return bookRepository.deleteById(id);
    }

    private Book findBookById(Long id) {
        return bookRepository.findById(id);
    }
    private Book bookDtoToBook(BookPostDto bookPostDto) {
        Book book = new Book();
        book.setTitle(bookPostDto.getTitle());
        book.setDescription(bookPostDto.getDescription());
        book.setIsbn(bookPostDto.getIsbn());
        book.setPublishDate(bookPostDto.getPublishDate());
        book.setAuthorId(bookPostDto.getAuthorId());
        return book;
    }
    private BookGetDto bookToBookGetDto(Book book) {
        return new BookGetDto(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getIsbn(),
                book.getPublishDate(),
                book.getAuthorId()
        );
    }

    private BookGetDetailedDto bookToBookGetDetailedDto(Book book) {
        return new BookGetDetailedDto(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getIsbn(),
                book.getPublishDate(),
                authorServiceClient.getAuthor(book.getAuthorId())
        );
    }
}
