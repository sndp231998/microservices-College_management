package com.library.services;

import java.util.List;

import com.library.entities.Borrow;

public interface BorrowService {

	//create 
		Borrow createBorrow(Borrow borrow);

		//get all
				List<Borrow>getAll();
				
				//get single
				Borrow get(Integer borrowId);
				
				//get All Borrows by userid
				List<Borrow>getBorrowByUserId(Integer userId);
}
