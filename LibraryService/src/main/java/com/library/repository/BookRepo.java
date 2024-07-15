package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.Book;
import com.library.entities.Borrow;



public interface BookRepo extends JpaRepository<Book, Integer>{

	
	
	
}