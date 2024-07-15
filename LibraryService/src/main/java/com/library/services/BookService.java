package com.library.services;

import java.util.List;
import java.util.Optional;

import com.library.entities.Book;

public interface BookService {

	//create
		Book create(Book book);
		
		//get all
		List<Book>getAll();
		
		//get single
		Book get(Integer bookId);
		
		
		//get All Books by userid
		//List<Book>getBookByUserId(Integer userId);
}
