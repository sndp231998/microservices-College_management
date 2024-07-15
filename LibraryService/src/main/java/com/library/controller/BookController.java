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

import com.library.entities.Book;
import com.library.services.BookService;


@RestController
@RequestMapping("/books")
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	// Create a new Book
	@PostMapping("/")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(book));
	}
	
	// Get single book by ID
	@GetMapping("/{bookId}/")
	public ResponseEntity<Book> getBook(@PathVariable Integer bookId) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.get(bookId));
	}
	
	// Get all book
	@GetMapping("/")
	public ResponseEntity<List<Book>> getAll() {
		return ResponseEntity.ok(bookService.getAll());
	}
	
}
