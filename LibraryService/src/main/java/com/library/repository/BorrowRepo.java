package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entities.Borrow;


public interface BorrowRepo extends JpaRepository<Borrow, Integer>  {

	List<Borrow> findByUserId(Integer userId);

//	@Query("select p from Borrow p where p.title like :key")
//List<Borrow> searchByTitle(@Param("key") String title);
}
