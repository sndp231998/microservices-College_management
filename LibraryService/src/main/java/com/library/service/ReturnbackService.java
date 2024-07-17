package com.library.service;

import java.util.List;

import com.library.playloads.ReturnbackDto;

public interface ReturnbackService {
	

ReturnbackDto createReturnBack(ReturnbackDto returnBackDto, Integer bookId);
	
	ReturnbackDto getReturnbackById(Integer returnBackId);

	List<ReturnbackDto> getAllReturnbacks();
	

	//get all Returns by user
	List<ReturnbackDto> getReturnbacksByUserId(Integer userId);
	
	//search borrows
	//List<BorrowDto> searchBorrows(String keyword);
}
