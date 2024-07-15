package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.entities.College;
import com.college.services.CollegeService;


@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	// Create a new college
	@PostMapping
	public ResponseEntity<College> createCollege(@RequestBody College college) {
		return ResponseEntity.status(HttpStatus.CREATED).body(collegeService.create(college));
	}
	
	// Get single college by ID
	@GetMapping("/{collegeId}")
	public ResponseEntity<College> getCollege(@PathVariable String collegeId) {
		return ResponseEntity.status(HttpStatus.OK).body(collegeService.get(collegeId));
	}
	
	// Get all colleges
	@GetMapping
	public ResponseEntity<List<College>> getAll() {
		return ResponseEntity.ok(collegeService.getAll());
	}
	

	//Get College By UserID
	@GetMapping("users/{userId}")
	public ResponseEntity<List<College>>getCollegeByUserId(Integer userId){
		return ResponseEntity.ok(collegeService.getCollegeByUserId(userId));
		
	}
}
