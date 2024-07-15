package com.library.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Book;
import com.library.exception.ResourceNotFoundException;
import com.library.repository.BookRepo;
import com.library.services.BookService;

@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookRepo bookRepo;

	@Override
	public Book create(Book book) {
		
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	@Override
	public Book get(Integer bookId) {
		return bookRepo.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "Id", bookId));
	}
	
//	@Override
//	public List<Book> getBookByUserId(Integer userId) {
//		
//		return bookRepo.findByUserId(userId);
//	}

	
}
