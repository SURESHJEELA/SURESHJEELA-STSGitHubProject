package com.capgemini.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.DepartmentServiceApplication;
import com.capgemini.entity.Department;
import com.capgemini.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	Logger log = LoggerFactory.getLogger(DepartmentServiceApplication.class);

	@Override
	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}

	@Override
	public Department findDepartmentById(Long departmentId) {
		log.info("Inside findDepartmentById of DepartmentService");
		return departmentRepository.findDepartmentById(departmentId);
	}
	
	
}
