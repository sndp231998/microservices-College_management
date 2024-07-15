package com.department.services;

import java.util.List;

import com.department.entities.Department;

public interface DepartmentService {

	//create
	Department create(Department department);
	
	//get all
	List<Department>getDepartment();
	
	//get Department by userid
	
	List<Department>getDepartmentByUserId(Integer userId);
	
	//get all by college
	
	List<Department>getDepartmentByCollegeId(String CollegeId);
	

	
	
}
