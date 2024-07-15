package com.college.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "college")
@Entity
@NoArgsConstructor
@Data
public class College {
	@Id
	private String collegeId;

	private String collegeName;

	private String location;

	private String about;
	
	private Integer userId;
}
