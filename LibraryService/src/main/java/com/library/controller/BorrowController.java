package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.playloads.BorrowDto;
import com.library.service.BorrowService;

@RestController
@RequestMapping("/borrows/")
public class BorrowController {

	@Autowired
	private BorrowService borrowService;

	
//	create product
	@PostMapping("/book/{bookId}")
	public ResponseEntity<BorrowDto> createBorrow(@RequestBody BorrowDto borrowDto,@PathVariable Integer bookId) {
		BorrowDto createBorrow = this.borrowService.createBorrow(borrowDto, bookId);
		return new ResponseEntity<BorrowDto>(createBorrow, HttpStatus.CREATED);
	}
	
	// get by user
		@GetMapping("/user/{userId}/borrows")
		public ResponseEntity<List<BorrowDto>> getBorrowsByUser(@PathVariable Integer userId) {

			List<BorrowDto> borrows = this.borrowService.getBorrowsByUserId(userId);
			return new ResponseEntity<List<BorrowDto>>(borrows, HttpStatus.OK);

		}
		
		
		
				// get borrow details by id

				@GetMapping("/borrows/{borrowId}")
				public ResponseEntity<BorrowDto> getBorrowById(@PathVariable Integer borrowId) {

					BorrowDto borrowDto = this.borrowService.getBorrowById(borrowId);
					return new ResponseEntity<BorrowDto>(borrowDto, HttpStatus.OK);

				}
				
				

				
				
				   //getall borrows
				 
				 		@GetMapping("/borrows/")
				 		public ResponseEntity<List<BorrowDto>> getAllBorrows() {
				 			return ResponseEntity.ok(this.borrowService.getAllBorrows());
				 		}
}

	
