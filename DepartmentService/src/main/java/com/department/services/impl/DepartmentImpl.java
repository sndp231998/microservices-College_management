package com.department.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.entities.Department;
import com.department.repository.DepartmentRepo;
import com.department.services.DepartmentService;

@Service
public class DepartmentImpl implements DepartmentService{
@Autowired
	private DepartmentRepo departmentrepo;
	
	@Override
	public Department create(Department department) {
		String departmentId=UUID.randomUUID().toString();
		department.setDepartmentId(departmentId);
		//department.setDepartmentName(departmentName);
		return departmentrepo.save(department);
	}

	@Override
	public List<Department> getDepartment() {
		// TODO Auto-generated method stub
		return departmentrepo.findAll();
	}

	@Override
	public List<Department> getDepartmentByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return departmentrepo.findByUserId(userId);
	}

	@Override
	public List<Department> getDepartmentByCollegeId(String CollegeId) {
		// TODO Auto-generated method stub
		return departmentrepo.findByCollegeId(CollegeId);
	}


}
