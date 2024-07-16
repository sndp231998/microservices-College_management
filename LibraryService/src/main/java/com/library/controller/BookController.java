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



import com.library.playloads.BookDto;
import com.library.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	
	
//	create
	@PostMapping("/")
	public ResponseEntity<BookDto> createWaste(@RequestBody BookDto bookDto) {
		BookDto createBook = this.bookService.createBook(bookDto);
		return new ResponseEntity<BookDto>(createBook, HttpStatus.CREATED);
	}
	
	
		
		
		// get waste details by id

		@GetMapping("/books/{bookId}")
		public ResponseEntity<BookDto> getBookById(@PathVariable Integer bookId) {

			BookDto bookDto = this.bookService.getBookById(bookId);
			return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);

		}

		


		// search waste
		@GetMapping("/books/search/{keywords}")
		public ResponseEntity<List<BookDto>> searchBookByName(@PathVariable("keywords") String keywords) {
			List<BookDto> result = this.bookService.searchBooks(keywords);
			return new ResponseEntity<List<BookDto>>(result, HttpStatus.OK);
		}

		// waste image upload

	
		
	    
	    //getall waste
	 // GET - 
	 		@GetMapping("/books/")
	 		public ResponseEntity<List<BookDto>> getAllBooks() {
	 			return ResponseEntity.ok(this.bookService.getAllBooks());
	 		}
		
		
}

