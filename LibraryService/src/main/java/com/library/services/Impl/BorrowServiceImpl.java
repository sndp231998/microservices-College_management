package com.library.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Book;
import com.library.entities.Borrow;
import com.library.exception.ResourceNotFoundException;
import com.library.repository.BookRepo;
import com.library.repository.BorrowRepo;
import com.library.services.BorrowService;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Borrow createBorrow(Borrow borrow) {
        
  
    	// Retrieve the book entity by its ID
        Book book = bookRepo.findById(borrow.getBook().getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found", null, 0));
        
        // Set the book to the borrow entity
        borrow.setBook(book);

  //Integer num= borrow.getBook().getBookId();
  
    System.out.println("this BookId ="+book);
   //borrow.setBook(book);
    
        borrow.setDate_of_giving(new Date());

        
        return borrowRepo.save(borrow);
    }

    @Override
    public List<Borrow> getAll() {
        return borrowRepo.findAll();
    }

    @Override
    public Borrow get(Integer borrowId) {
        return borrowRepo.findById(borrowId)
                         .orElseThrow(() -> new ResourceNotFoundException("Borrow", "Id", borrowId));
    }

    @Override
    public List<Borrow> getBorrowByUserId(Integer userId) {
        return borrowRepo.findByUserId(userId);
    }

}
