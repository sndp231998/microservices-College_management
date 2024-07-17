package com.library.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.library.entities.Borrow;



public interface BorrowRepo extends JpaRepository<Borrow ,Integer> {
	List<Borrow> findByUserId(Integer user);
	
	Optional<Borrow> findByBookIdAndUserId(Integer bookId, Integer userId);

	

	
}
