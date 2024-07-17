package com.library.services.Impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.entities.Book;
import com.library.entities.Borrow;
import com.library.entities.Returnback;
import com.library.exception.ResourceNotFoundException;
import com.library.playloads.ReturnbackDto;
import com.library.repository.BookRepo;
import com.library.repository.BorrowRepo;
import com.library.repository.ReturnBackRepo;
import com.library.service.ReturnbackService;

public class ReturnbackServiceImpl implements ReturnbackService{

	 @Autowired
	    private BorrowRepo borrowRepo;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Autowired
	    private BookRepo bookRepo;
	    
	    @Autowired
	    private ReturnBackRepo returnBackRepo;
	    

	@Override
	public ReturnbackDto createReturnBack(ReturnbackDto retuenBackDto, Integer bookId) {
		
		// Get userId from ReturnbackDto
        Integer userId = retuenBackDto.getUserId();
        
        Optional<Borrow> borrowOptional = this.borrowRepo.findByBookIdAndUserId(bookId, userId);
        if (!borrowOptional.isPresent()) {
            // Handle the case when the borrow entry is not found
            throw new IllegalArgumentException("No borrow record found for the given book id and user id");
        }
        
		 
        Borrow borrow = borrowOptional.get();
        
        // Increase the book quantity by 1
        borrow.getBook().setQty(borrow.getBook().getQty() + 1);
        this.bookRepo.save(borrow.getBook());

        
     // Create the ReturnBack entity
        Returnback returnBack = this.modelMapper.map(retuenBackDto, Returnback.class);
        returnBack.setBorrow(borrow);
        
        Returnback newReturnBack = this.returnBackRepo.save(returnBack);

        // Delete the borrow entry
        this.borrowRepo.delete(borrow);

        return this.modelMapper.map(newReturnBack, ReturnbackDto.class);
        
	}

	@Override
	public ReturnbackDto getReturnbackById(Integer returnBackId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReturnbackDto> getAllReturnbacks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReturnbackDto> getReturnbacksByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
