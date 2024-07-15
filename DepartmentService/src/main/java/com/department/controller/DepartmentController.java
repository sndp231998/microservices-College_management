package com.department.controller;

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

import com.department.entities.Department;
import com.department.services.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	//create Department
	@PostMapping("/")
	public ResponseEntity<Department>create(
			@RequestBody Department department){
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.create(department));
	}
	
	
	//GetAll of user department
	@GetMapping("/")
	public ResponseEntity<List<Department>>getDepartments(){
		return ResponseEntity.ok(departmentService.getDepartment());
		
	}
	
	//Get all department By UserID
	@GetMapping("users/{userId}")
	public ResponseEntity<List<Department>>getDepartmentsByUserId(@PathVariable Integer userId){
		// System.out.println("Fetching departments for userId: " + userId);
		 List<Department>dep=departmentService.getDepartmentByUserId(userId);
		 //System.out.println("Fetching departments: " + dep);
		 return ResponseEntity.ok(dep);
		//return ResponseEntity.ok(departmentService.getDepartmentByUserId(userId));
		
	}
	//get all department by collegeid
	
	@GetMapping("/colleges/{collegeId}")
	public ResponseEntity<List<Department>>getDepartmentsByCollegeId(@PathVariable String collegeId){
		 //System.out.println("Fetching departments for collegeId: " + collegeId);
		    List<Department> departments = departmentService.getDepartmentByCollegeId(collegeId);
		    //System.out.println("Fetching departments: " + departments);
		    return ResponseEntity.ok(departments);
	}
}
