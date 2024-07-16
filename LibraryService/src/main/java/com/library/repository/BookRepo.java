package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entities.Book;



public interface BookRepo extends JpaRepository<Book, Integer>{

	
	//List<Book> findByTitle(Title title);	
	
	@Query("select b from Book b where b.title like :key")
	List<Book> searchByTitle(@Param("key") String title);
}
