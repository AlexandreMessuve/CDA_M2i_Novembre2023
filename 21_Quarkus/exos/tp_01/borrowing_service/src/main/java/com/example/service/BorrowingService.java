package com.example.service;

import com.example.client.BookServiceClient;
import com.example.client.UserServiceClient;
import com.example.dto.BorrowingGetDto;
import com.example.dto.BorrowingPostDto;
import com.example.entity.Borrowing;
import com.example.repository.BorrowingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class BorrowingService {
    @Inject
    BorrowingRepository borrowingRepository;

    @Inject
    @RestClient
    BookServiceClient bookServiceClient;

    @Inject
    @RestClient
    UserServiceClient userServiceClient;

    public List<BorrowingGetDto> getBorrowings() {
        return borrowingRepository.findAll().stream().map(this::borrowingToBorrowingGetDto).toList();
    }

    public List<BorrowingGetDto> getActiveBorrowings() {
        return getBorrowings().stream().filter(borrowing -> borrowing.getEndDate().isAfter(LocalDate.now())).toList();
    }

    public List<BorrowingGetDto> getIntervalBorrowings(LocalDate startDate, LocalDate endDate) {
        return getBorrowings().stream().filter(borrowing -> borrowing.getStartDate().isAfter(startDate) && borrowing.getEndDate().isBefore(endDate)).toList();
    }

    public boolean isBookBorrowing(Long bookId) {
        boolean flag = false;
        for (BorrowingGetDto borrowing : getBorrowingsByBookId(bookId)){
            if (borrowing.getEndDate().isAfter(LocalDate.now())){
                flag = true;
                break;
            }
        }
        return flag;
    }
    public BorrowingGetDto getBorrowingById(Long id) {
        return borrowingToBorrowingGetDto(findBorrowingById(id));
    }

    public List<BorrowingGetDto> getBorrowingsByUserId(Long userId) {
        return borrowingRepository.findByUserId(userId).stream().map(this::borrowingToBorrowingGetDto).toList();
    }
    public List<BorrowingGetDto> getBorrowingsByBookId(Long bookId) {
        return borrowingRepository.findByBookId(bookId).stream().map(this::borrowingToBorrowingGetDto).toList();
    }

    @Transactional
    public BorrowingGetDto addBorrowing(BorrowingPostDto borrowingPostDto) {
        Borrowing borrowing = borrowingDtoToBorrowing(borrowingPostDto);
        if (!isBookBorrowing(borrowing.getBookId())){
            borrowingRepository.persistAndFlush(borrowing);
            if (borrowingRepository.isPersistent(borrowing)){
                return borrowingToBorrowingGetDto(borrowing);
            }
        }
        return null;
    }

    @Transactional
    public BorrowingGetDto updateBorrowing(Long id, BorrowingPostDto borrowingUpdate) {
        Borrowing borrowing = findBorrowingById(id);
        if (borrowing != null){
            borrowing.setStartDate(borrowingUpdate.getStartDate());
            borrowing.setEndDate(borrowingUpdate.getEndDate());
            borrowing.setBookId(borrowingUpdate.getBookId());
            borrowing.setUserId(borrowingUpdate.getUserId());
            borrowingRepository.persistAndFlush(borrowing);
            if (borrowingRepository.isPersistent(borrowing)){
                return borrowingToBorrowingGetDto(borrowing);
            }
        }
        return null;
    }

    @Transactional
    public boolean deleteBorrowing(Long id) {
        return borrowingRepository.deleteById(id);
    }

    private Borrowing findBorrowingById(Long id) {
        return borrowingRepository.findById(id);
    }

    private Borrowing borrowingDtoToBorrowing(BorrowingPostDto borrowingPostDto) {
        Borrowing borrowing = new Borrowing();
        borrowing.setStartDate(borrowingPostDto.getStartDate());
        borrowing.setEndDate(borrowingPostDto.getEndDate());
        borrowing.setBookId(borrowingPostDto.getBookId());
        borrowing.setUserId(borrowingPostDto.getUserId());
        return borrowing;
    }

    private BorrowingGetDto borrowingToBorrowingGetDto(Borrowing borrowing) {
        return new BorrowingGetDto(
                borrowing.getId(),
                borrowing.getStartDate(),
                borrowing.getEndDate(),
                bookServiceClient.findBookDetailById(borrowing.getBookId()),
                userServiceClient.findUser(borrowing.getUserId())
        );
    }
}
