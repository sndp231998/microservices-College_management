package com.college.services;

import java.util.List;

import com.college.entities.College;

public interface CollegeService {

	
	//create
	College create(College college);
	
	//get all
	List<College>getAll();
	
	//get single
	College get(String collegeId);
	
	//get college by userid
	List<College>getCollegeByUserId(Integer userId);
}
