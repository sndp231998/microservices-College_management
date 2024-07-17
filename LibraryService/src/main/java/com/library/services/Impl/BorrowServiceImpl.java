package com.library.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Book;
import com.library.entities.Borrow;
import com.library.exception.ResourceNotFoundException;
import com.library.playloads.BorrowDto;
import com.library.repository.BookRepo;
import com.library.repository.BorrowRepo;
import com.library.service.BorrowService;
@Service
public class BorrowServiceImpl implements BorrowService{

	
	
	 @Autowired
	    private BorrowRepo borrowRepo;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Autowired
	    private BookRepo bookRepo;
	    

	
	
	@Override
	public BorrowDto createBorrow(BorrowDto borrowDto, Integer bookId) {
		Book book = this.bookRepo.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "book id", bookId));
		
		if (book.getQty() <= 0) {
            throw new IllegalArgumentException("No copies of the book are available to borrow.");
        }
		
		//Decrease the book qty by 1
		book.setQty(book.getQty()-1);
		this.bookRepo.save(book);
		
		 Borrow borrow = this.modelMapper.map(borrowDto, Borrow.class);
	     
		 borrow.setDate_of_giving(new Date());
         borrow.setBook(book);
        
	        Borrow newBorrow = this.borrowRepo.save(borrow);

	        return this.modelMapper.map(newBorrow, BorrowDto.class);

	}

	@Override
	public BorrowDto getBorrowById(Integer borrowId) {
		Borrow borrow = this.borrowRepo.findById(borrowId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow", "borrow id", borrowId));
        return this.modelMapper.map(borrow, BorrowDto.class);	
	}

	@Override
	public List<BorrowDto> getAllBorrows() {
		List<Borrow> borrows = this.borrowRepo.findAll();
        return borrows.stream()
                .map(product -> this.modelMapper.map(product, BorrowDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public List<BorrowDto> getBorrowsByUserId(Integer userId) {

		List<Borrow> borrows = this.borrowRepo.findByUserId(userId);
        return borrows.stream()
                .map(borrow -> this.modelMapper.map(borrow, BorrowDto.class))
                .collect(Collectors.toList());

   //     return borrowDtos;
	}

}
