package com.college.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entities.College;



public interface CollegeRepo extends JpaRepository<College, String>{
	
	//custom find methods
	List<College>findByUserId(Integer userId);
	//List<College>findByCollegeId(String collegeId);
}