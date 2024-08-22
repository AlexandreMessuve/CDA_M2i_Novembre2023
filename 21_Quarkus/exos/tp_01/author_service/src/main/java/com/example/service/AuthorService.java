package com.example.service;

import com.example.client.BookServiceClient;
import com.example.dto.AuthorGetDetailDto;
import com.example.dto.AuthorGetDto;
import com.example.dto.AuthorPostDto;
import com.example.entity.Author;
import com.example.repository.AuthorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class AuthorService {
    @Inject
    AuthorRepository authorRepository;

    @Inject
    @RestClient
    BookServiceClient bookServiceClient;


    public List<AuthorGetDetailDto> getAuthorDetailList(){
        return authorRepository.findAll().stream().map(this::authorToAuthorGetDetailDto).toList();
    }

    public List<AuthorGetDto> getAuthorList() {
        return authorRepository.findAll().stream().map(this::authorToAuthorGetDto).toList();
    }

    public AuthorGetDetailDto getAuthorDetail(Long id){
        return authorToAuthorGetDetailDto(findAuthorById(id));
    }
    public AuthorGetDto getAuthorById(Long id) {
        return authorToAuthorGetDto(findAuthorById(id));
    }

    @Transactional
    public AuthorGetDto addAuthor(AuthorPostDto authorPostDto) {
        Author author = authorDtoToAuthor(authorPostDto);
        authorRepository.persistAndFlush(author);
        if (authorRepository.isPersistent(author)){
            return authorToAuthorGetDto(author);
        }else{
            return null;
        }
    }
    @Transactional
    public AuthorGetDto updateAuthor(Long id,AuthorPostDto authorUpdate) {
        Author author = findAuthorById(id);
        if (author != null) {
            author.setName(authorUpdate.getName());
            author.setBiography(authorUpdate.getBiography());
            author.setBirthDate(authorUpdate.getBirthDate());
            authorRepository.persistAndFlush(author);
            if (authorRepository.isPersistent(author)){
                return authorToAuthorGetDto(author);
            }
        }
        return null;
    }

    @Transactional
    public boolean deleteAuthor(Long id) {
        return authorRepository.deleteById(id);
    }

    private Author findAuthorById(Long id) {
        return authorRepository.findById(id);
    }
    private Author authorDtoToAuthor(AuthorPostDto authorPostDto) {
        Author author = new Author();
        author.setName(authorPostDto.getName());
        author.setBiography(authorPostDto.getBiography());
        author.setBirthDate(authorPostDto.getBirthDate());
        return author;
    }
    private AuthorGetDto authorToAuthorGetDto(Author author) {
        return new AuthorGetDto(
                author.getId(),
                author.getName(),
                author.getBiography(),
                author.getBirthDate()
        );
    }
    private AuthorGetDetailDto authorToAuthorGetDetailDto(Author author) {
        return new AuthorGetDetailDto(
                author.getId(),
                author.getName(),
                author.getBiography(),
                author.getBirthDate(),
                bookServiceClient.searchBook(author.getId())
        );
    }
}
