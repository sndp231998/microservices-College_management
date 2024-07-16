package com.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.library.entities.Borrow;



public interface BorrowRepo extends JpaRepository<Borrow ,Integer> {
	//List<Borrow> findByUser(User user);
	
	

	
}
