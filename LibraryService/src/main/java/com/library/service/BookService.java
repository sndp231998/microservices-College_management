package com.library.service;

import java.util.List;

import com.library.playloads.BookDto;

public interface BookService {

	BookDto createBook(BookDto bookDto);
	
	BookDto getBookById(Integer bookId);

	List<BookDto> getAllBooks();
	
	//search wastes
		List<BookDto> searchBooks(String keyword);

}
