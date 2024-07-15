package com.department.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//if mangodb [@Document("rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Department {
@Id
	private String departmentId;
	
	private Integer userId;
	
	private String collegeId;
	
	private String bookId;
	
	private String departmentName;
	
	
	
	
}
