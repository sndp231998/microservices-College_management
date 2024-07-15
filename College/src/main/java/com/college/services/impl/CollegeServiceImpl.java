package com.college.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.entities.College;
import com.college.exceptions.ResourceNotFoundException;
import com.college.repositories.CollegeRepo;
import com.college.services.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepo collegeRepo;

	@Override
	public List<College> getAll() {
		return collegeRepo.findAll();
	}

	@Override
	public College get(String collegeId) {
		return collegeRepo.findById(collegeId)
				.orElseThrow(() -> new ResourceNotFoundException("College", "Id", collegeId));
	}

	@Override
	public College create(College college) {
		String cId = UUID.randomUUID().toString();
		college.setCollegeId(cId);
		return collegeRepo.save(college);
	}

	@Override
	public List<College> getCollegeByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return collegeRepo.findByUserId(userId);
	}
}
