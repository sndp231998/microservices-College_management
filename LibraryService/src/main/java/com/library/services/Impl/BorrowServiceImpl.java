package com.library.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import com.library.entities.Borrow;
import com.library.exception.ResourceNotFoundException;
import com.library.playloads.BorrowDto;
import com.library.repository.BookRepo;
import com.library.repository.BorrowRepo;
import com.library.service.BorrowService;

public class BorrowServiceImpl implements BorrowService{

	
	
	 @Autowired
	    private BorrowRepo borrowRepo;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Autowired
	    private BookRepo bookRepo;
	    
//	    @Autowired
//	    private UserRepo userRepo;
	
	
	@Override
	public BorrowDto createBorrow(BorrowDto borrowDto, Integer userId, Integer bookId) {
		// TODO Auto-generated method stub
		return null;
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
	public List<BorrowDto> getBorrowsByUser(Integer userId) {
//		User user = this.userRepo.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
//        List<Borrow> borrows = this.borrowRepo.findByUser(user);

 //       List<BorrowDto> borrowDtos = borrows.stream().map((borrow) -> this.modelMapper.map(borrow, BorrowDto.class))
 //               .collect(Collectors.toList());
return null;
   //     return borrowDtos;
	}

}
