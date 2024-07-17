package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.Returnback;

public interface ReturnBackRepo extends JpaRepository<Returnback ,Integer> {
	List<Returnback> findByUserId(Integer userId);
	

}
