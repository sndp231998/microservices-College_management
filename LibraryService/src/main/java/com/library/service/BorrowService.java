package com.library.service;

import java.util.List;

import com.library.playloads.BorrowDto;


public interface BorrowService {
	
BorrowDto createBorrow(BorrowDto borrowDto, Integer userId, Integer bookId);
	

	//BorrowDto updateProduct(BorrowDto borrowDto, Integer borrowId);
	

	BorrowDto getBorrowById(Integer borrowId);

	List<BorrowDto> getAllBorrows();

	//void deleteBorrow(Integer borrowId);
	
	

	
	//get all borrows by user
	List<BorrowDto> getBorrowsByUser(Integer userId);
	
	//search borrows
	//List<BorrowDto> searchBorrows(String keyword);
}
