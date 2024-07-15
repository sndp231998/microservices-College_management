package com.department.repository;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department,String>{

	//custom find methods
	List<Department>findByUserId(Integer userId);
	
	List<Department>findByCollegeId(String collegeId);
	
}
